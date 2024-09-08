package com.mepsanakademi.mepsan.controller;

import com.mepsanakademi.mepsan.model.BaseEntity;
import com.mepsanakademi.mepsan.service.GenericService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class GenericController<T extends BaseEntity> {

    private final GenericService<T> service;

    @GetMapping
    public List<T> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable String id) {
        Optional<T> entityOptional = service.getById(id);
        return entityOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T savedEntity = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable String id, @RequestBody T entity) {
        Optional<T> existingEntityOptional = service.getById(id);
        if (existingEntityOptional.isPresent()) {
            T existingEntity = existingEntityOptional.get();
            entity.setId(existingEntity.getId());
            T updatedEntity = service.save(entity);
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Optional<T> existingEntityOptional = service.getById(id);
        if (existingEntityOptional.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
