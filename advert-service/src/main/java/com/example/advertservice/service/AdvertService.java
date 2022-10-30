package com.example.advertservice.service;

import com.example.advertservice.client.PurchaseCountClient;
import com.example.advertservice.client.UserClient;
import com.example.advertservice.entity.Advert;
import com.example.advertservice.enums.AdvertStatus;
import com.example.advertservice.event.AdvertPlacedEvent;
import com.example.advertservice.repository.AdvertRepository;
import com.example.advertservice.requests.PurchaseCountRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdvertService {

    private final Logger logger = LoggerFactory.getLogger(AdvertService.class);
    private final AdvertRepository advertRepository;
    private final UserClient userClient;
    private final PurchaseCountClient purchaseCountClient;
    private final KafkaTemplate<String, String> kafkaTemplate;
    public List<Advert> getAllAdvert() {
        return advertRepository.findAll();
    }

    public Advert publishAdvert(Advert advert, int userId) {
        userClient.getUserById(userId);
        checkPurchaseCount(userId);
        advert.setAdvertStatus(AdvertStatus.IN_REVIEW);
        advert.setUserId(userId);
        Advert savedAdvert = advertRepository.save(advert);
        kafkaTemplate.send("Emre","Advert Created");
        logger.info("Satın Alım Yapıldı");
        return savedAdvert;
    }

    public void checkPurchaseCount(int id) {
        ResponseEntity<PurchaseCountRequest> purchaseCount = purchaseCountClient.getPurchaseCount(id);

        if(purchaseCount.getBody() != null && purchaseCount.getBody().getRemainingTotal() > 0) {
            purchaseCount.getBody().setRemainingTotal(purchaseCount.getBody().getRemainingTotal() - 1);
            purchaseCountClient.updatePurchaseCount(purchaseCount.getBody());
        }
        else {
            throw new RuntimeException("Satın Alma Paketiniz Yok");
        }
    }

    public void publishMessage(String name) {
        kafkaTemplate.send("Emre", name);
        logger.info("Message sent: "+name);
    }

}
