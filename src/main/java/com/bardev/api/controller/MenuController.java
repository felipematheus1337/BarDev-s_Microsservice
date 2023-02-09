package com.bardev.api.controller;


import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.service.menu.impl.MenuAlcoholServiceImpl;
import com.bardev.domain.service.menu.impl.MenuBitterServiceImpl;
import com.bardev.domain.service.menu.impl.MenuColorServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Developers Bar"))
public class MenuController {

    private final MenuAlcoholServiceImpl menuAlcoholService;
    private final MenuBitterServiceImpl menuBitterService;
    private final MenuColorServiceImpl menuColorService;

    @GetMapping("/alcool/maior")
    @Operation(summary = "Endpoint para buscar cervejas com maior teor alcoolico",
            description = "Endpoint para buscar cervejas com maior teor alcoolico")
    public ResponseEntity<List<BeerDTO>> getWithHigherAlcoholPercentage() {
        var beers = menuAlcoholService.getHigher();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/alcool/moderado")
    @Operation(summary = "Endpoint para buscar cervejas com teor alcoolico moderado",
            description = "Endpoint para buscar cervejas com teor alcoolico moderado")
    public ResponseEntity<List<BeerDTO>> getWithModerateAlcoholPercentage() {
        var beers = menuAlcoholService.getModerate();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/alcool/menor")
    @Operation(summary = "Endpoint para buscar cervejas com teor alcoolico baixo",
            description = "Endpoint para buscar cervejas com teor alcoolico baixo")
    public ResponseEntity<List<BeerDTO>> getWithWeakerAlcoholPercentage() {
        var beers = menuAlcoholService.getWeaker();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/bitter/maior")
    @Operation(summary = "Endpoint para buscar cervejas com amargura elevada",
            description = "Endpoint para buscar cervejas com amargura elevada")
    public ResponseEntity<List<BeerDTO>> getWithHigherBitter() {
        var beers = menuBitterService.getHigher();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/bitter/moderado")
    @Operation(summary = "Endpoint para buscar cervejas com amargura moderada",
            description = "Endpoint para buscar cervejas com amargura moderada")
    public ResponseEntity<List<BeerDTO>> getWithModerateBitter() {
        var beers = menuBitterService.getModerate();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/bitter/menor")
    @Operation(summary = "Endpoint para buscar cervejas com amargura leve",
            description = "Endpoint para buscar cervejas com amargura leve")
    public ResponseEntity<List<BeerDTO>> getWithWeakerBitter() {
        var beers = menuBitterService.getWeaker();
        return ResponseEntity.ok(beers);
    }


    @GetMapping("/color/escura")
    @Operation(summary = "Endpoint para buscar cervejas com cor escura",
            description = "Endpoint para buscar cervejas com cor escura")
    public ResponseEntity<List<BeerDTO>> getWithHigherColor() {
        var beers = menuColorService.getHigher();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/color/amber")
    @Operation(summary = "Endpoint para buscar cervejas com cor moderada",
            description = "Endpoint para buscar cervejas com cor moderada")
    public ResponseEntity<List<BeerDTO>> getWithModerateColor() {
        var beers = menuColorService.getModerate();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/color/clara")
    @Operation(summary = "Endpoint para buscar cervejas com cor clara",
            description = "Endpoint para buscar cervejas com cor clara")
    public ResponseEntity<List<BeerDTO>> getWithLighterColor() {
        var beers = menuColorService.getWeaker();
        return ResponseEntity.ok(beers);
    }





}
