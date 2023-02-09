package com.bardev.api.controller;


import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.service.menu.impl.MenuAlcoholServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuAlcoholServiceImpl menuAlcoholService;

    @GetMapping("/maior")
    public ResponseEntity<List<BeerDTO>> getWithHigherAlcoholPercentage() {
        var beers = menuAlcoholService.getHigher();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/moderado")
    public ResponseEntity<List<BeerDTO>> getWithModerateAlcoholPercentage() {
        var beers = menuAlcoholService.getModerate();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/menor")
    public ResponseEntity<List<BeerDTO>> getWithWeakerAlcoholPercentage() {
        var beers = menuAlcoholService.getWeaker();
        return ResponseEntity.ok(beers);
    }


}
