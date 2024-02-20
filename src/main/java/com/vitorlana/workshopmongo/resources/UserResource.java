package com.vitorlana.workshopmongo.resources;

import com.vitorlana.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>>  findAll(){
        User maria =  new User("1", "Maria Brow", "mariaBrow@gmail.com");
        User alex =  new User("2", "Alex Robert", "alexRobert@gmail.com");
        User jeff =  new User("3", "jeff bowie", "jeffbowie@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(maria, alex, jeff));
        return ResponseEntity.ok().body(list);
    }



}
