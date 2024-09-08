package com.mepsanakademi.mepsan.config;

import com.mepsanakademi.mepsan.model.*;
import com.mepsanakademi.mepsan.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private RecyclingTransactionRepository recyclingTransactionRepository;
    @Autowired
    private RewardRepository rewardRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private UserRepository userRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            if (storeRepository.count() == 0 &&
                    machineRepository.count() == 0 &&
                    materialRepository.count() == 0 &&
                    userRepository.count() == 0 &&
                    recyclingTransactionRepository.count() == 0 &&
                    rewardRepository.count() == 0) {
                // Store
                Store store1 = new Store("Ahmet Yılmaz", "İstanbul, Kadıköy", "12312312");
                List<String> machinesId = new ArrayList<>();
                machinesId.add("1");
                machinesId.add("2");
                store1.setMachinesId(machinesId);
                storeRepository.save(store1);

                // Machine
                Machine machine1 = new Machine("1", "Aktif", "SN123456");
                Machine machine2 = new Machine("2", "Bakımda", "SN789012");
                machineRepository.save(machine1);
                machineRepository.save(machine2);

                // Material
                Material material1 = new Material("PET", 0.50, LocalDateTime.now());
                Material material2 = new Material("Cam", 1.00, LocalDateTime.now());
                materialRepository.save(material1);
                materialRepository.save(material2);

                // User
                User user1 = new User("1", "example@example.com", "50511111111", "123456", 10.00, LocalDateTime.now());
                User user2 = new User("2","example2@example.com", "50522222222", "789012", 15.00, LocalDateTime.now());
                userRepository.save(user1);
                userRepository.save(user2);

                // RecyclingTransaction
                RecyclingTransaction transaction1 = new RecyclingTransaction("1", new ArrayList<RecyclingMaterial>(), "1", 10.0);
                List<RecyclingMaterial> materials1 = new ArrayList<RecyclingMaterial>();
                materials1.add(new RecyclingMaterial(material1.getId(), 1, 0.50));
                materials1.add(new RecyclingMaterial(material1.getId(), 2, 1.00));
                transaction1.setMaterials(materials1);
                RecyclingTransaction transaction2 = new RecyclingTransaction("2", new ArrayList<RecyclingMaterial>(), "2", 15.0);
                List<RecyclingMaterial> materials2 = new ArrayList<RecyclingMaterial>();
                materials2.add(new RecyclingMaterial(material1.getId(), 3, 1.00));
                materials2.add(new RecyclingMaterial(material2.getId(), 1, 0.50));
                transaction2.setMaterials(materials2);
                recyclingTransactionRepository.save(transaction1);
                recyclingTransactionRepository.save(transaction2);

                // Reward
                Reward reward1 = new Reward("1", new BigDecimal(1), new BigDecimal("10.00"));
                rewardRepository.save(reward1);
            }
        };
    }
}

