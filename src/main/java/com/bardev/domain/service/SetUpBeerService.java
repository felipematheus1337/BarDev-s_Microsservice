package com.bardev.domain.service;


import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.dto.BeerDTO;
import com.bardev.api.mapper.BeerMapper;
import com.bardev.domain.entity.Beer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SetUpBeerService {

    private final BeerMapper beerMapper;

    public List<BeerDTO> setUpTheBeers(List<BeerResponse> beers, double value) {
        List<Beer> beer = new ArrayList<Beer>();
        for(BeerResponse b: beers) {
            Beer cerveja = new Beer();
            cerveja.setId(b.getId().toString());
            cerveja.setName(b.getName());
            cerveja.setPrice(value);
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
