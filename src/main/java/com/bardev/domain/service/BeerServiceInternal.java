package com.bardev.domain.service;

import com.bardev.domain.entity.Beer;

import java.util.List;

public interface BeerServiceInternal {

    List<Beer> listOfHighBitterBeers();

    List<Beer> listOfLowBitterBeers();

    List<Beer> listOfModerateBitterBeers();

    List<Beer> highAlcoholBeer();

    List<Beer> lowAlcoholBeer();

    List<Beer> moderateAlcoholBeer();

    List<Beer> lightColorBeer();

    List<Beer> ambarColorBeer();

    List<Beer> darkColorBeer();

    Beer getBeerByName();

    Beer getRandomBeer();




}
