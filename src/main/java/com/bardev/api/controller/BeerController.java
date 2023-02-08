package com.bardev.api.controller;


import com.bardev.api.client.repository.BeerClient;
import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import com.bardev.domain.entity.Beer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;


    /*@GetMapping("/alcool/fraco")
    private ResponseEntity<Beer> getBeerWithWeakAlcohol() {
        var beerResponse =beerService.getGreaterAbv(5);
        Random random = new Random();
        int randomIndex = random.nextInt(beerResponse.size());
        var beerFinded = beerResponse.get(randomIndex);
        Beer cerveja = new Beer();
        cerveja.setId(beerFinded.getId().toString());
        cerveja.setPrice(300);
        cerveja.setName(beerFinded.getName());
        cerveja.setDescription(beerFinded.getDescription());
        cerveja.setAlcoholLevel(
                beerFinded.getAbv()  != null ? beerFinded.getAbv() : 0.0
        );
        cerveja.setBitternessLevel(
                beerFinded.getIbu() != null ? beerFinded.getIbu() : 0.0
        );
        cerveja.setColorLevel(
                beerFinded.getEbc() != null ? beerFinded.getEbc() : 0.0
        );
        return ResponseEntity.ok(cerveja);
    }

     */


}
