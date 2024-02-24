package com.vitorlana.workshopmongo.repository;

import com.vitorlana.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    //Query methods Simples https://docs.spring.io/spring-data/data-document/docs/current/reference/html/#repositories.query-methods
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

}
