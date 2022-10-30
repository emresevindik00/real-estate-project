package com.example.purchaseservice.repository;

import com.example.purchaseservice.entity.AdvertPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertPackageRepository extends JpaRepository<AdvertPackage, Integer> {

    boolean existsById(int id);
}
