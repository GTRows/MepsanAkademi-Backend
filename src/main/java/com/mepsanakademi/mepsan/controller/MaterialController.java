package com.mepsanakademi.mepsan.controller;

import com.mepsanakademi.mepsan.model.Material;
import com.mepsanakademi.mepsan.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/material")
public class MaterialController extends GenericController<Material> {
    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        super(materialService);
        this.materialService = materialService;
    }
}
