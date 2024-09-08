package com.mepsanakademi.mepsan.controller;

import com.mepsanakademi.mepsan.model.RecyclingTransaction;
import com.mepsanakademi.mepsan.service.RecyclingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recycling")
public class RecyclingController extends GenericController<RecyclingTransaction> {
    private final RecyclingService recyclingService;

    @Autowired
    public RecyclingController(RecyclingService recyclingService) {
        super(recyclingService);
        this.recyclingService = recyclingService;
    }

}
