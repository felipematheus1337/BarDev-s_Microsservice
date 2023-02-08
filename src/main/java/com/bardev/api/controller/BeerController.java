package com.bardev.api.controller;


import com.bardev.api.client.repository.BeerClient;
import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.service.BeerServiceInternal;
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

    private final BeerServiceInternal beerServiceInternal;


    @GetMapping("/alcool/fraco")
    private ResponseEntity<List<Beer>> getAllBeersWithStrongBitter() {
          var beers = beerServiceInternal.listOfHighBitterBeers();
          return ResponseEntity.ok(beers);
    }




}
