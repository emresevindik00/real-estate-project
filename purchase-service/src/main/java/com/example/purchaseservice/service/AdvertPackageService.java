package com.example.purchaseservice.service;

import com.example.purchaseservice.entity.AdvertPackage;
import com.example.purchaseservice.repository.AdvertPackageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdvertPackageService {

    private final AdvertPackageRepository advertPackageRepository;

    public AdvertPackage getById(int id) {
        return advertPackageRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }
}
