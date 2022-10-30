package com.example.advertservice.client;

import com.example.advertservice.requests.PurchaseCountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "purchase-service", url = "http://localhost:8085/purchase-counts")
public interface PurchaseCountClient {
    @GetMapping("/{id}")
    ResponseEntity<PurchaseCountRequest> getPurchaseCount(@PathVariable int id);

    @PutMapping
    ResponseEntity<PurchaseCountRequest> updatePurchaseCount(@RequestBody PurchaseCountRequest purchaseCountRequest);
}
