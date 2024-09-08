package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.model.RecyclingTransaction;
import com.mepsanakademi.mepsan.repository.RecyclingTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecyclingService extends GenericService<RecyclingTransaction> {
    private final RecyclingTransactionRepository recyclingTransactionRepository;

    @Autowired
    public RecyclingService(RecyclingTransactionRepository recyclingTransactionRepository) {
        super(recyclingTransactionRepository);
        this.recyclingTransactionRepository = recyclingTransactionRepository;
    }
}
