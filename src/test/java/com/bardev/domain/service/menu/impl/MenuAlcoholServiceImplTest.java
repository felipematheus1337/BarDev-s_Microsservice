package com.bardev.domain.service.menu.impl;

import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import com.bardev.api.dto.BeerDTO;
import com.bardev.api.mapper.BeerMapper;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.entity.enums.AlcoholLevel;
import com.bardev.domain.service.SetUpBeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MenuAlcoholServiceImplTest {



    @InjectMocks
    MenuAlcoholServiceImpl service;

    @Mock
    BeerService beerService;

    @Mock
    SetUpBeerService setUp;

    @Mock
    BeerMapper mapper;

    @BeforeEach
    void up() {

    }

    @Test
    public void getHigher_shouldReturnListOfHigherAlcoholBeers() {
        double highAlcoholBeerPriceDefault = 20.0;

        // Given
        List<BeerResponse> beerResponseList = Arrays.asList(
                new BeerResponse(1L, "Heineken", "Champions League", 9.0, 5.0, 10.0),
                new BeerResponse(2L, "Skol", "Cerveja Brasileira", 10.0, 7.0, 12.0)
        );
        when(beerService.getGreaterAbv(8)).thenReturn(beerResponseList);

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

        when(setUp.setUpTheBeers(beerResponseList, highAlcoholBeerPriceDefault)).thenReturn(beerDTOList);

        // When
        List<BeerDTO> result = service.getHigher();

        // Then
        assertNotNull(result);
        assertEquals(result.size(), 2);
        assertEquals(result, beerDTOList);
        assertEquals(result.get(1).getAlcoholLevel(),AlcoholLevel.ALTO);
    }

    @Test
    void getWeaker() {
        double lowAlcoholBeerPriceDefault = 9.0;
        List<BeerResponse> beerResponseList = Arrays.asList(
                new BeerResponse(1L, "Heineken", "Champions League", 4.0, 5.0, 10.0),
                new BeerResponse(2L, "Skol", "Cerveja Brasileira", 3.0, 7.0, 12.0)
        );
        when(beerService.getLesserAbv(5)).thenReturn(beerResponseList);

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

        when(setUp.setUpTheBeers(beerResponseList,lowAlcoholBeerPriceDefault)).thenReturn(beerDTOList);

        List<BeerDTO> beers = service.getWeaker();

        assertEquals(beers.get(1).getId(),"2");
        assertEquals(beers.get(1).getAlcoholLevel(), AlcoholLevel.BAIXO);

    }


    @Test
    void getModerate() {
        double moderateAlcoholBeerPriceDefault = 14.0;
        List<BeerResponse> beerResponseList = Arrays.asList(
                new BeerResponse(1L, "Heineken", "Champions League", 6.0, 5.0, 10.0),
                new BeerResponse(2L, "Skol", "Cerveja Brasileira", 6.0, 7.0, 12.0)
        );
        when(beerService.getGreaterAbv(5)).thenReturn(beerResponseList);

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

        when(setUp.setUpTheBeers(beerResponseList,moderateAlcoholBeerPriceDefault)).thenReturn(beerDTOList);


        List<BeerDTO> beers = service.getModerate();
        assertEquals(beers.size(),2);
        assertEquals(beers.get(0).getAlcoholLevel(),AlcoholLevel.MODERADO);
        assertEquals(beers.get(1).getAlcoholLevel(),AlcoholLevel.MODERADO);
    }



}

