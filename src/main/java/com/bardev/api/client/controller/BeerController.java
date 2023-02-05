package com.bardev.api.client.controller;

import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{id}")
    public List<BeerResponse> buscarPorId(@PathVariable Long id) {
        return beerService.getBeerById(id);
    }

    @GetMapping()
    public List<BeerResponse> getRandomBeer() {
        return beerService.getRandomBeer();
    }
}
