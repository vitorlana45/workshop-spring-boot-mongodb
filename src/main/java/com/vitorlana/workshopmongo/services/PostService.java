package com.vitorlana.workshopmongo.services;

import com.vitorlana.workshopmongo.domain.Post;
import com.vitorlana.workshopmongo.repository.PostRepository;
import com.vitorlana.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }




}
