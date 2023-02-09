package com.bardev.domain.service.menu.impl;

import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import com.bardev.api.dto.BeerDTO;
import com.bardev.api.mapper.BeerMapper;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.entity.enums.AlcoholLevel;
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
    private final BeerMapper beerMapper;




    @Override
    public List<BeerDTO> getHigher() {
        double highAlcoholBeerPriceDefault = 20.0;
        return setUpBeers(beerService.getGreaterAbv(8), highAlcoholBeerPriceDefault);
    }

    @Override
    public List<BeerDTO> getModerate() {
        double moderateAlcoholBeerPriceDefault = 14.0;
        var beers =  setUpBeers(beerService.getGreaterAbv(5),moderateAlcoholBeerPriceDefault);
        return beers.stream()
                .filter(beerDTO -> {
                    return beerDTO.getAlcoholLevel() == AlcoholLevel.MODERADO;
                }).collect(Collectors.toList());

    }

    @Override
    public List<BeerDTO> getWeaker() {
        double lowAlcoholBeerPriceDefault = 9.0;
        return setUpBeers(beerService.getLesserAbv(5),lowAlcoholBeerPriceDefault);

    }


    private List<BeerDTO> setUpBeers(List<BeerResponse> beers, double beerTypePrice) {
        List<Beer> beer = new ArrayList<Beer>();
        for(BeerResponse b: beers) {
            Beer cerveja = new Beer();
            cerveja.setId(b.getId().toString());
            cerveja.setName(b.getName());
            cerveja.setPrice(beerTypePrice);
            cerveja.setDescription(b.getDescription());
            cerveja.setAlcoholLevel(
                    b.getAbv() != null ? b.getAbv() : 0.0
            );
            cerveja.setBitternessLevel(
                    b.getIbu() != null ? b.getIbu() : 0.0
            );
            cerveja.setColorLevel(
                    b.getEbc() != null ? b.getEbc() : 0.0
            );
            beer.add(cerveja);
        }
        return beerMapper.beerDTOList(beer);

    }
}
