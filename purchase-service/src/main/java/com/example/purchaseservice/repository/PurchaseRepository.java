package com.example.purchaseservice.repository;

import com.example.purchaseservice.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    Optional<List<Purchase>> findByUserId(int userId);
}
