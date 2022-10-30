package com.example.purchaseservice.repository;

import com.example.purchaseservice.entity.PurchaseCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseCountRepository extends JpaRepository<PurchaseCount, Integer> {
    List<PurchaseCount> findAllByUserId(int userId);

    @Query("select pc from PurchaseCount pc where pc.userId =?1 and pc.endDate > CURRENT_DATE ")
    PurchaseCount getAllCurrentPurchaseCount(int userId);
}
