package com.mepsanakademi.mepsan.controller;

import com.mepsanakademi.mepsan.model.Store;
import com.mepsanakademi.mepsan.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController extends GenericController<Store> {
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        super(storeService);
        this.storeService = storeService;
    }
}
