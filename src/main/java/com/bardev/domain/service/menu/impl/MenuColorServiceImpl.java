package com.bardev.domain.service.menu.impl;

import com.bardev.api.client.service.BeerService;
import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.enums.ColorLevel;
import com.bardev.domain.service.SetUpBeerService;
import com.bardev.domain.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MenuColorServiceImpl implements MenuService {


    private final BeerService beerService;
    private final SetUpBeerService setUp;


    @Override
    public List<BeerDTO> getHigher() {
        double strongColorPriceDefault = 40;
        return setUp.setUpTheBeers(beerService.getGreaterEbc(33),strongColorPriceDefault);
    }

    @Override
    public List<BeerDTO> getModerate() {
        double moderateColorPriceDefault = 25;
        return setUp.setUpTheBeers(beerService.getGreaterEbc(12),moderateColorPriceDefault)
                .stream()
                .filter(beerDTO -> {
                    return beerDTO.getColorLevel() == ColorLevel.AMBAR;
                }).collect(Collectors.toList());
    }

    @Override
    public List<BeerDTO> getWeaker() {
        double weakerColorPriceDefault = 11;
        return setUp.setUpTheBeers(beerService.getLesserEbc(12),weakerColorPriceDefault);
    }
}
