package com.vitorlana.workshopmongo.config;

import com.vitorlana.workshopmongo.domain.User;
import com.vitorlana.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll(); // limpando a coleção dentro do mongoDB Local

        User maria = new User(null, "maria", "maria@gmail.com");
        User joao = new User(null, "joao", "joao@gmail.com");
        User fred = new User(null, "fred", "fred@gmail.com");

        userRepository.saveAll(Arrays.asList(maria ,joao, fred));
    }
}
