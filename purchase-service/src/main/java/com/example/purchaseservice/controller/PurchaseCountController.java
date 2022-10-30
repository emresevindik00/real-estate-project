package com.example.purchaseservice.controller;

import com.example.purchaseservice.entity.PurchaseCount;
import com.example.purchaseservice.service.PurchaseCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/purchase-counts")
@RestController
@RequiredArgsConstructor
public class PurchaseCountController {

    private final PurchaseCountService purchaseCountService;

    @GetMapping({"/{id}"})
    public ResponseEntity<PurchaseCount> getPurchaseCount(@PathVariable int id){
        return ResponseEntity.ok(purchaseCountService.getPurchaseCount(id));
    }

    @PutMapping
    ResponseEntity<PurchaseCount> update(@RequestBody PurchaseCount purchaseCount){
        return ResponseEntity.ok(purchaseCountService.purchaseCountUpdate(purchaseCount));
    }

}

