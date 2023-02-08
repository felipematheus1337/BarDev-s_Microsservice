package com.bardev.domain.service.impl;

import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.service.BeerServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BeerServiceInternalImpl implements BeerServiceInternal {

    private final BeerService beerService;


    @Override
    public List<Beer> listOfHighBitterBeers() {
        var beerResponse = beerService.getGreaterIbu(40);
        return setUpBeer(beerResponse);
    }

    @Override
    public List<Beer> listOfLowBitterBeers() {
        return null;
    }

    @Override
    public List<Beer> listOfModerateBitterBeers() {
        return null;
    }

    @Override
    public List<Beer> highAlcoholBeer() {
        return null;
    }

    @Override
    public List<Beer> lowAlcoholBeer() {
        return null;
    }

    @Override
    public List<Beer> moderateAlcoholBeer() {
        return null;
    }

    @Override
    public List<Beer> lightColorBeer() {
        return null;
    }

    @Override
    public List<Beer> ambarColorBeer() {
        return null;
    }

    @Override
    public List<Beer> darkColorBeer() {
        return null;
    }

    @Override
    public Beer getBeerByName() {
        return null;
    }

    @Override
    public Beer getRandomBeer() {
        return null;
    }

    private List<Beer> setUpBeer(List<BeerResponse> beerResponses){
        List<Beer> beers = new ArrayList<>();
        for(BeerResponse b: beerResponses) {
            Beer cerveja = new Beer();
            cerveja.setId(b.getId().toString());
            cerveja.setPrice(300);
            cerveja.setName(b.getName());
            cerveja.setDescription(b.getDescription());
            cerveja.setAlcoholLevel(
                    b.getAbv()  != null ? b.getAbv() : 0.0
            );
            cerveja.setBitternessLevel(
                    b.getIbu() != null ? b.getIbu() : 0.0
            );
            cerveja.setColorLevel(
                    b.getEbc() != null ? b.getEbc() : 0.0
            );
            beers.add(cerveja);
        }

        return beers;

    }
}
