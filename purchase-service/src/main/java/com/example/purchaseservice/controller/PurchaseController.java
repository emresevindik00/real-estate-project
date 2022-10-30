package com.example.purchaseservice.controller;

import com.example.purchaseservice.entity.Purchase;
import com.example.purchaseservice.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;



    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase, @RequestHeader(value = "id") int id) {
        return ResponseEntity.ok(purchaseService.create(purchase, id));
    }

    @PutMapping
    public ResponseEntity<Purchase> updatePurchase(@RequestBody Purchase user, @RequestHeader(value = "id") int id) {
        return new ResponseEntity<>(purchaseService.update(user, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable int id) {
        return new ResponseEntity<>(purchaseService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getByUserId(@RequestHeader("id") int userId){
        return ResponseEntity.ok(purchaseService.getByUserId(userId));
    }
}
