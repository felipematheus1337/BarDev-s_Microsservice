package com.bardev.domain.service.menu.impl;

import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.entity.enums.BitternessLevel;
import com.bardev.domain.service.SetUpBeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MenuBitterServiceImplTest {

    @InjectMocks
    MenuBitterServiceImpl service;

    @Mock
    BeerService beerService;

    @Mock
    SetUpBeerService setUpBeerService;



    @Test
    void getHigher() {
        double highBitterPriceDefault = 15;
        List<BeerResponse> beerResponseList = Arrays.asList(
                new BeerResponse(1L, "Heineken", "Champions League", 9.0, 41.0, 10.0),
                new BeerResponse(2L, "Skol", "Cerveja Brasileira", 10.0, 41.0, 12.0)
        );
        when(beerService.getGreaterIbu(40)).thenReturn(beerResponseList);

        List<BeerDTO> beerDTOList = new ArrayList<>();
        for(BeerResponse b : beerResponseList) {
            Beer pivot = new Beer();
            pivot.setAlcoholLevel(b.getAbv());
            pivot.setBitternessLevel(b.getIbu());
            pivot.setColorLevel(b.getEbc());

            BeerDTO beerDTO = new BeerDTO();
            beerDTO.setId(b.getId().toString());
            beerDTO.setName(b.getName());
            beerDTO.setDescription(b.getDescription());
            beerDTO.setAlcoholLevel(pivot.getAlcoholLevel());
            beerDTO.setBitternessLevel(pivot.getBitternessLevel());
            beerDTO.setColorLevel( pivot.getColorLevel());
            beerDTOList.add(beerDTO);
        }

        when(setUpBeerService.setUpTheBeers(beerResponseList,highBitterPriceDefault)).thenReturn(beerDTOList);

       var beerResultList =  service.getHigher();
        assertEquals(beerResultList.get(1).getBitternessLevel(), BitternessLevel.FORTE);

    }

    @Test
    void getModerate() {
        double moderateBitterPriceDefault = 9;
        List<BeerResponse> beerResponseList = Arrays.asList(
                new BeerResponse(1L, "Heineken", "Champions League", 9.0, 31.0, 10.0),
                new BeerResponse(2L, "Skol", "Cerveja Brasileira", 10.0, 31.0, 12.0)
        );
        when(beerService.getGreaterIbu(30)).thenReturn(beerResponseList);

        List<BeerDTO> beerDTOList = new ArrayList<>();
        for(BeerResponse b : beerResponseList) {
            Beer pivot = new Beer();
            pivot.setAlcoholLevel(b.getAbv());
            pivot.setBitternessLevel(b.getIbu());
            pivot.setColorLevel(b.getEbc());

            BeerDTO beerDTO = new BeerDTO();
            beerDTO.setId(b.getId().toString());
            beerDTO.setName(b.getName());
            beerDTO.setDescription(b.getDescription());
            beerDTO.setAlcoholLevel(pivot.getAlcoholLevel());
            beerDTO.setBitternessLevel(pivot.getBitternessLevel());
            beerDTO.setColorLevel( pivot.getColorLevel());
            beerDTOList.add(beerDTO);
        }


        when(setUpBeerService.setUpTheBeers(beerResponseList,moderateBitterPriceDefault)).thenReturn(beerDTOList);

        var beersResultList = service.getModerate();
        assertEquals(beersResultList.size(),2);
        assertEquals(beersResultList.get(0).getBitternessLevel(),BitternessLevel.MODERADO);
    }

    @Test
    void getWeaker() {
        double weakerBitterPriceDefault = 6;
        List<BeerResponse> beerResponseList = Arrays.asList(
                new BeerResponse(1L, "Heineken", "Champions League", 9.0, 28.0, 10.0),
                new BeerResponse(2L, "Skol", "Cerveja Brasileira", 10.0, 25.0, 12.0)
        );
        when(beerService.getLesserIbu(30)).thenReturn(beerResponseList);

        List<BeerDTO> beerDTOList = new ArrayList<>();
        for(BeerResponse b : beerResponseList) {
            Beer pivot = new Beer();
            pivot.setAlcoholLevel(b.getAbv());
            pivot.setBitternessLevel(b.getIbu());
            pivot.setColorLevel(b.getEbc());

            BeerDTO beerDTO = new BeerDTO();
            beerDTO.setId(b.getId().toString());
            beerDTO.setName(b.getName());
            beerDTO.setDescription(b.getDescription());
            beerDTO.setAlcoholLevel(pivot.getAlcoholLevel());
            beerDTO.setBitternessLevel(pivot.getBitternessLevel());
            beerDTO.setColorLevel( pivot.getColorLevel());
            beerDTOList.add(beerDTO);
        }

        when(setUpBeerService.setUpTheBeers(beerResponseList,weakerBitterPriceDefault)).thenReturn(beerDTOList);

        var beersResultList = service.getWeaker();
        assertEquals(beersResultList.get(0).getBitternessLevel(),BitternessLevel.FRACO);
        assertEquals(beersResultList.size(),2);
    }
}