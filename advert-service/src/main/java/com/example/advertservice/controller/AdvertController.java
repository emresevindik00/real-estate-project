package com.example.advertservice.controller;

import com.example.advertservice.entity.Advert;
import com.example.advertservice.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adverts")
@RequiredArgsConstructor
public class AdvertController {
    private final AdvertService advertService;

    @GetMapping
    public ResponseEntity<List<Advert>> getAllAdvert() {
        return new ResponseEntity<>(advertService.getAllAdvert(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Advert> create(@RequestBody Advert advert, @RequestHeader(value = "id") int id) {
        return new ResponseEntity<>(advertService.publishAdvert(advert, id), HttpStatus.OK);
    }

    @PostMapping("/message")
    public String publishMessage(@RequestBody String message) {
        advertService.publishMessage(message);
        return message;
    }

}
