package com.bardev.api.controller;


import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.service.menu.impl.MenuAlcoholServiceImpl;
import com.bardev.domain.service.menu.impl.MenuBitterServiceImpl;
import com.bardev.domain.service.menu.impl.MenuColorServiceImpl;
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
    private final MenuBitterServiceImpl menuBitterService;
    private final MenuColorServiceImpl menuColorService;

    @GetMapping("/alcool/maior")
    public ResponseEntity<List<BeerDTO>> getWithHigherAlcoholPercentage() {
        var beers = menuAlcoholService.getHigher();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/alcool/moderado")
    public ResponseEntity<List<BeerDTO>> getWithModerateAlcoholPercentage() {
        var beers = menuAlcoholService.getModerate();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/alcool/menor")
    public ResponseEntity<List<BeerDTO>> getWithWeakerAlcoholPercentage() {
        var beers = menuAlcoholService.getWeaker();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/bitter/maior")
    public ResponseEntity<List<BeerDTO>> getWithHigherBitter() {
        var beers = menuBitterService.getHigher();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/bitter/moderado")
    public ResponseEntity<List<BeerDTO>> getWithModerateBitter() {
        var beers = menuBitterService.getModerate();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/bitter/menor")
    public ResponseEntity<List<BeerDTO>> getWithWeakerBitter() {
        var beers = menuBitterService.getWeaker();
        return ResponseEntity.ok(beers);
    }


    @GetMapping("/color/escura")
    public ResponseEntity<List<BeerDTO>> getWithHigherColor() {
        var beers = menuColorService.getHigher();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/color/amber")
    public ResponseEntity<List<BeerDTO>> getWithModerateColor() {
        var beers = menuColorService.getModerate();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/color/clara")
    public ResponseEntity<List<BeerDTO>> getWithLighterColor() {
        var beers = menuColorService.getWeaker();
        return ResponseEntity.ok(beers);
    }





}
