package com.example.advertservice.client;

import com.example.advertservice.requests.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-client", url = "http://localhost:8085/users")
public interface UserClient {
    @GetMapping("/{id}")
    ResponseEntity<UserRequest> getUserById(@PathVariable int id);
}
