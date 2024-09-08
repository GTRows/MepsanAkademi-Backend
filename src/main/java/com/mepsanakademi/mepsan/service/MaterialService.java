package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.model.Material;
import com.mepsanakademi.mepsan.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService extends GenericService<Material> {
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        super(materialRepository);
        this.materialRepository = materialRepository;
    }
}
