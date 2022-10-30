package com.example.purchaseservice.service;

import com.example.purchaseservice.entity.Purchase;
import com.example.purchaseservice.entity.PurchaseCount;
import com.example.purchaseservice.repository.PurchaseCountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseCountService {
    private final PurchaseCountRepository purchaseCountRepository;

    public void purchaseCount(Purchase purchase, int userId) {
        PurchaseCount currentPurchaseCount = purchaseCountRepository.getAllCurrentPurchaseCount(userId);


        if(currentPurchaseCount == null) {
            PurchaseCount purchaseCount = new PurchaseCount();
            purchaseCount.setUserId(userId);
            purchaseCount.setStartDate(purchase.getPurchaseDate());
            purchaseCount.setEndDate(purchase.getPurchaseDate().plusDays(30));
            purchaseCount.setTotal(10);
            purchaseCount.setRemainingTotal(10);
            purchaseCountRepository.save(purchaseCount);
        } else {
            currentPurchaseCount.setEndDate(currentPurchaseCount.getEndDate().plusDays(30));
            currentPurchaseCount.setTotal(currentPurchaseCount.getTotal() + 10);
            currentPurchaseCount.setRemainingTotal(currentPurchaseCount.getRemainingTotal() + 10);
            purchaseCountRepository.save(currentPurchaseCount);
        }
    }

    public PurchaseCount getPurchaseCount(int id) {
        return purchaseCountRepository.getAllCurrentPurchaseCount(id);
    }

    public PurchaseCount purchaseCountUpdate(PurchaseCount purchaseCount) {
        PurchaseCount purchaseCount1 = purchaseCountRepository
                .findById(purchaseCount.getPurchaseCountId()).orElseThrow(() -> new RuntimeException("Yok"));

        purchaseCount1.setRemainingTotal(purchaseCount.getRemainingTotal());
        return purchaseCountRepository.save(purchaseCount1);
    }
}
