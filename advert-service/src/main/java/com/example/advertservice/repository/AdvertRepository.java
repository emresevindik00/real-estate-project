package com.example.advertservice.repository;

import com.example.advertservice.entity.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {

    Optional<Advert> findByAdvertNo(Long advertNo);
}
