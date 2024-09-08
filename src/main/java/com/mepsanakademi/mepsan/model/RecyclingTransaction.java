package com.mepsanakademi.mepsan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "recyclingTransactions")
@Getter
@Setter
public class RecyclingTransaction extends BaseEntity{
    private String userId;
    private List<RecyclingMaterial> materials;
    private String machineId;
    private BigDecimal reward;
    private LocalDateTime transactionDate;

    public RecyclingTransaction(String userId, List<RecyclingMaterial> materials, String machineId, BigDecimal reward){
        this.userId = userId;
        this.materials = materials;
        this.machineId = machineId;
        this.reward = reward;
        this.transactionDate = LocalDateTime.now();
    }

}

