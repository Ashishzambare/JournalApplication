package com.example.JournalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.JournalApp.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    User findByUserName(String username);

    void deleteByUserName(String username);

    Optional<User> findById(ObjectId id);

    void deleteById(ObjectId id);


    // add custom queries if needed, e.g. Optional<User> findByUsername(String username);
}