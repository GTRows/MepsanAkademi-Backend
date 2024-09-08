package com.mepsanakademi.mepsan.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "recyclingTransactions")
@Getter
@Setter
@NoArgsConstructor
public class RecyclingTransaction extends BaseEntity{
    private String userId;
    private List<RecyclingMaterial> materials;
    private String machineId;
    private double reward;
    private LocalDateTime transactionDate;

    public RecyclingTransaction(String userId, List<RecyclingMaterial> materials, String machineId, double reward){
        this.userId = userId;
        this.materials = materials;
        this.machineId = machineId;
        this.reward = reward;
        this.transactionDate = LocalDateTime.now();
    }


    public void setMaterials(List<RecyclingMaterial> materials) {
        this.materials = materials;
        calculateReward();
    }

    private void calculateReward(){
        this.reward = 0;
        for(RecyclingMaterial material : materials){
            this.reward += material.getReward() * material.getQuantity();
        }
    }
}

