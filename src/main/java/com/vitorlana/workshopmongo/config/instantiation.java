package com.vitorlana.workshopmongo.config;


import com.vitorlana.workshopmongo.domain.Post;
import com.vitorlana.workshopmongo.domain.User;
import com.vitorlana.workshopmongo.repository.PostRepository;
import com.vitorlana.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class instantiation implements CommandLineRunner {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll(); // limpando a coleção dentro do mongoDB Local


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User joao = new User(null, "Joao Green", "joao@gmail.com");
        User fred = new User(null, "Fred White", "fred@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, joao, fred));
        postRepository.saveAll(Arrays.asList(post1, post2));


    }
}
