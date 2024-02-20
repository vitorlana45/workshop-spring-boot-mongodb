package com.vitorlana.workshopmongo.services;

import com.sun.source.tree.BreakTree;
import com.vitorlana.workshopmongo.domain.User;
import com.vitorlana.workshopmongo.repository.UserRepository;
import com.vitorlana.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
}
