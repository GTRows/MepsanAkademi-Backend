package com.mepsanakademi.mepsan.dto.responseDto;

import com.mepsanakademi.mepsan.model.Machine;
import com.mepsanakademi.mepsan.model.RecyclingTransaction;
import com.mepsanakademi.mepsan.model.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminData {
    private Machine machine;
    private Store store;
    private List<RecyclingTransaction> recyclingTransactions;
}

