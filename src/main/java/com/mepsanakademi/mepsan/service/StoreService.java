package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.model.Store;
import com.mepsanakademi.mepsan.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService extends GenericService<Store> {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        super(storeRepository);
        this.storeRepository = storeRepository;
    }
}
