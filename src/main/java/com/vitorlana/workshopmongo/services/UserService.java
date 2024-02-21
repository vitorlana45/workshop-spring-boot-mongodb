package com.vitorlana.workshopmongo.services;

import com.sun.source.tree.BreakTree;
import com.vitorlana.workshopmongo.domain.User;
import com.vitorlana.workshopmongo.dto.UserDTO;
import com.vitorlana.workshopmongo.repository.UserRepository;
import com.vitorlana.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }


    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void Delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        String id = obj.getId();
        User newObj = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("usuário não encontrado!") );
        updateData(newObj, obj);
        return userRepository.save(newObj);

    }

    private void updateData(User newObjToUpdate, User objClientUpdate) {
        newObjToUpdate.setName(objClientUpdate.getName());
        newObjToUpdate.setEmail(objClientUpdate.getEmail());
    }
}
