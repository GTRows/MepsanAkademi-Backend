package com.mepsanakademi.mepsan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "Materials")
@Getter
@Setter
@AllArgsConstructor
public class Material extends BaseEntity{
    private String type;
    private BigDecimal rewardPerItem;
    private LocalDateTime createdAt;
}
