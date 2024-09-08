package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
}
