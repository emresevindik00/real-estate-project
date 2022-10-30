package com.example.purchaseservice.service;

import com.example.purchaseservice.client.UserClient;
import com.example.purchaseservice.entity.Purchase;
import com.example.purchaseservice.repository.AdvertPackageRepository;
import com.example.purchaseservice.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final AdvertPackageRepository advertPackageRepository;
    private final UserClient userClient;
    private final PurchaseCountService purchaseCountService;

    @Transactional
    public Purchase create(Purchase purchase, int id) {
        checkNotInUse(purchase, id);
        purchaseCountService.purchaseCount(purchase, id);
        purchase.setUserId(id);
        return purchase;
    }

    public Purchase update(Purchase purchase, int id) {
        getById(purchase.getPurchaseId());
        checkNotInUse(purchase, id);
        return purchaseRepository.save(purchase);
    }

    public Purchase getById(int id) {
        return purchaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Purchase> getByUserId(int id) {
        return purchaseRepository.findByUserId(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }
    public void checkNotInUse(Purchase purchase, int id) {
        if(!userClient.existsUser(id)) {
            throw new RuntimeException("Not Found");
        }
        if(!advertPackageRepository.existsById(purchase.getAdvertPackage().getAdvertId())) {
            throw new RuntimeException("Not Found");
        }
    }
}
