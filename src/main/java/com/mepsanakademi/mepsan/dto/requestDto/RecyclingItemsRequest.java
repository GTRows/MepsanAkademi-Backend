package com.mepsanakademi.mepsan.dto.requestDto;

import com.mepsanakademi.mepsan.model.RecyclingMaterial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecyclingItemsRequest {
    private String userId;
    private List<RecyclingMaterial> materials;
    private String machineId;
    private LocalDateTime transactionDate;
}
