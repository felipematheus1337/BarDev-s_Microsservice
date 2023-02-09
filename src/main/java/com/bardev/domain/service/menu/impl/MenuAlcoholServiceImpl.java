package com.bardev.domain.service.menu.impl;

import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import com.bardev.api.dto.BeerDTO;
import com.bardev.api.mapper.BeerMapper;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.entity.enums.AlcoholLevel;
import com.bardev.domain.service.SetUpBeerService;
import com.bardev.domain.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuAlcoholServiceImpl implements MenuService {

    private final BeerService beerService;
    private final SetUpBeerService setUp;





    @Override
    public List<BeerDTO> getHigher() {
        double highAlcoholBeerPriceDefault = 20.0;
        return setUp.setUpTheBeers(beerService.getGreaterAbv(8), highAlcoholBeerPriceDefault);
    }



    @Override
    public List<BeerDTO> getModerate() {
        double moderateAlcoholBeerPriceDefault = 14.0;
        var beers =  setUp.setUpTheBeers(beerService.getGreaterAbv(5),moderateAlcoholBeerPriceDefault);
        return beers.stream()
                .filter(beerDTO -> {
                    return beerDTO.getAlcoholLevel() == AlcoholLevel.MODERADO;
                }).collect(Collectors.toList());

    }

    @Override
    public List<BeerDTO> getWeaker() {
        double lowAlcoholBeerPriceDefault = 9.0;
        return setUp.setUpTheBeers(beerService.getLesserAbv(5),lowAlcoholBeerPriceDefault);

    }




}
