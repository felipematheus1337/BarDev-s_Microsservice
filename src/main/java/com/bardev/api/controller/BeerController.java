package com.bardev.api.controller;


import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.service.internal.impl.BeerInternalServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {


    private final BeerInternalServiceImpl beerInternalService;


    @PostMapping
    @Operation(summary = "Endpoint criar cervejas",
            description = "Endpoint para criar cervejas")
    public ResponseEntity<BeerDTO> createAnBeer(@RequestBody Beer beer) {
        var beerCreated = beerInternalService.createBeer(beer);
        return ResponseEntity.ok(beerCreated);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint que busca uma cerveja",
            description = "Endpoint que busca uma cerveja")
    public ResponseEntity<BeerDTO> getOneBeer(@PathVariable String id) {
        return beerInternalService.getOneBeerById(id)
                .map(beer -> ResponseEntity.ok(beer))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Endpoint que busca todas as cervejas",
            description = "Endpoint que busca todas as cervejas")
    public ResponseEntity<BeerDTO> getAllBeers() {
        return beerInternalService.findALL()
                .stream()
                .map(ResponseEntity::ok)
                .findAny()
                .get();
    }

    @PutMapping
    @Operation(summary = "Endpoint que atualiza uma cerveja",
            description = "Endpoint que atualiza uma cerveja")
    public ResponseEntity<BeerDTO> updateBeer(@PathVariable String id, @RequestBody Beer beer) {
        return ResponseEntity.ok(beerInternalService.updateAnBeer(id,beer));
    }



}
