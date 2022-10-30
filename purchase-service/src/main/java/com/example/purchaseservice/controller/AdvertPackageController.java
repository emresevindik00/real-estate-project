package com.example.purchaseservice.controller;

import com.example.purchaseservice.entity.AdvertPackage;
import com.example.purchaseservice.service.AdvertPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advert-packages")
@RequiredArgsConstructor
public class AdvertPackageController {

    private final AdvertPackageService advertPackageService;

    @GetMapping("/{id}")
    public ResponseEntity<AdvertPackage> getById(@PathVariable int id) {
        return new ResponseEntity<>(advertPackageService.getById(id), HttpStatus.OK);
    }
}
