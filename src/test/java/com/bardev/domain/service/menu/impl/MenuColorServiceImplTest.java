package com.bardev.domain.service.menu.impl;

import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.enums.ColorLevel;
import com.bardev.domain.service.SetUpBeerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MenuColorServiceImplTest {

    @InjectMocks
    MenuColorServiceImpl service;

    @Mock
    BeerService beerService;

    @Mock
    SetUpBeerService setUpBeerService;


    @Test
    void getHigher() {
        double strongColorPriceDefault = 40;
        List<BeerResponse> beerResponseList = Arrays.asList(
                new BeerResponse(1L, "Heineken", "Champions League", 9.0, 41.0, 34.0),
                new BeerResponse(2L, "Skol", "Cerveja Brasileira", 10.0, 41.0, 34.0)
        );
        when(beerService.getGreaterEbc(33)).thenReturn(beerResponseList);

        List<BeerDTO> beerDTOList = Arrays.asList(
                new BeerDTO("1L", "Heineken", "Champions League", 9.0, 41.0, 34.0),
                new BeerDTO("2L", "Skol", "Cerveja Brasileira", 10.0, 41.0, 34.0)
        );
        when(setUpBeerService.setUpTheBeers(beerResponseList,strongColorPriceDefault)).thenReturn(beerDTOList);

        var beerResultList =  service.getHigher();
        assertEquals(beerResultList.get(0).getColorLevel(), ColorLevel.ESCURA);

    }

    @Test
    void getModerate() {
        double moderateColorPriceDefault = 25;
        List<BeerResponse> beerResponseList = Arrays.asList(
                new BeerResponse(1L, "Heineken", "Champions League", 9.0, 41.0, 13.0),
                new BeerResponse(2L, "Skol", "Cerveja Brasileira", 10.0, 41.0, 30.0)
        );
        when(beerService.getGreaterEbc(12)).thenReturn(beerResponseList);

        List<BeerDTO> beerDTOList = Arrays.asList(
                new BeerDTO("1L", "Heineken", "Champions League", 9.0, 41.0, 13.0),
                new BeerDTO("2L", "Skol", "Cerveja Brasileira", 10.0, 41.0, 30.0),
                new BeerDTO("2L", "Skol", "Cerveja Brasileira", 10.0, 41.0, 44.0)
        );
        when(setUpBeerService.setUpTheBeers(beerResponseList,moderateColorPriceDefault)).thenReturn(beerDTOList);

        var beerResultList =  service.getModerate();
        assertEquals(beerResultList.get(0).getColorLevel(), ColorLevel.AMBAR);
        assertEquals(beerResultList.size(),2);
    }

    @Test
    void getWeaker() {
        double weakerColorPriceDefault = 11;
        List<BeerResponse> beerResponseList = Arrays.asList(
                new BeerResponse(1L, "Heineken", "Champions League", 9.0, 41.0, 11.0),
                new BeerResponse(2L, "Skol", "Cerveja Brasileira", 10.0, 41.0, 9.0)
        );
        when(beerService.getLesserEbc(12)).thenReturn(beerResponseList);

        List<BeerDTO> beerDTOList = Arrays.asList(
                new BeerDTO("1L", "Heineken", "Champions League", 9.0, 41.0, 11.0),
                new BeerDTO("2L", "Skol", "Cerveja Brasileira", 10.0, 41.0, 9.0)
        );
        when(setUpBeerService.setUpTheBeers(beerResponseList,weakerColorPriceDefault)).thenReturn(beerDTOList);

        var beerResultList =  service.getWeaker();
        assertEquals(beerResultList.get(0).getColorLevel(), ColorLevel.CLARA);
    }
}