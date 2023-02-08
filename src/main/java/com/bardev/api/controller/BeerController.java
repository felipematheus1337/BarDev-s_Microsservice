package com.bardev.api.controller;


import com.bardev.domain.entity.Beer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
