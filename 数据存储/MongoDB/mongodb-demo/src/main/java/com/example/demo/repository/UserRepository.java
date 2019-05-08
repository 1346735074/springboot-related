package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author purgeyao
 * @since 1.0
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

}
