package com.mepsanakademi.mepsan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "materials")
@Getter
@Setter
@AllArgsConstructor
public class Material extends BaseEntity{
    private String type;
    private double rewardPerItem;
    private LocalDateTime createdAt;

    public Material(String type, double rewardPerItem){
        this.type = type;
        this.rewardPerItem = rewardPerItem;
        this.createdAt = LocalDateTime.now();
    }
}
