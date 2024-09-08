package com.mepsanakademi.mepsan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
public abstract class BaseEntity {
    @Id
    @Setter
    private String id;

    BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
