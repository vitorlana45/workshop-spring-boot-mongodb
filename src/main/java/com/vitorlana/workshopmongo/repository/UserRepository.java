package com.vitorlana.workshopmongo.repository;

import com.vitorlana.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {

}
