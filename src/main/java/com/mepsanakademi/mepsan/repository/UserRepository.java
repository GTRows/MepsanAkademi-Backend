package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
