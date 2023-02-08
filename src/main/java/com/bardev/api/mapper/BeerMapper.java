package com.bardev.api.mapper;


import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.Beer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BeerMapper {

    private final ModelMapper modelMapper;

    public Beer toBeer(BeerDTO beerDTO) {
        return modelMapper.map(beerDTO, Beer.class);
    }

    public BeerDTO toDTO(Beer beer) {
        return modelMapper.map(beer, BeerDTO.class);
    }


    public List<BeerDTO> beerDTOList(List<Beer> beers) {
        return beers
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


}
