package com.mepsanakademi.mepsan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class RecyclingMaterial {
    private String materialId;
    private Double weight;
    private BigDecimal reward;
}
