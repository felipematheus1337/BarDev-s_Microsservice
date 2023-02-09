package com.bardev.domain.service.menu.impl;

import com.bardev.api.client.service.BeerService;
import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.enums.BitternessLevel;
import com.bardev.domain.service.SetUpBeerService;
import com.bardev.domain.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuBitterServiceImpl implements MenuService {

    private final BeerService beerService;
    private final SetUpBeerService setUp;

    @Override
    public List<BeerDTO> getHigher() {
        double highBitterPriceDefault = 15;
        return setUp.setUpTheBeers(beerService.getGreaterIbu(40),highBitterPriceDefault);

    }

    @Override
    public List<BeerDTO> getModerate() {
        double moderateBitterPriceDefault = 9;
        return setUp.setUpTheBeers(beerService.getGreaterIbu(30),moderateBitterPriceDefault)
                .stream()
                .filter(beerDTO -> {
                    return beerDTO.getBitternessLevel() == BitternessLevel.MODERADO;
                }).collect(Collectors.toList());
    }

    
    @Override
    public List<BeerDTO> getWeaker() {
        double weakerBitterPriceDefault = 6;
        return setUp.setUpTheBeers(beerService.getLesserIbu(30),weakerBitterPriceDefault);
    }
}
