package com.example.purchaseservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8085/users")
public interface UserClient {

    @GetMapping("/exist/{id}")
    boolean existsUser(@PathVariable int id);
}
