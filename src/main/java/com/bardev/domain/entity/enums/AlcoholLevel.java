package com.bardev.domain.entity.enums;

import com.bardev.domain.repository.LevelConverter;

import java.util.stream.Stream;

public enum AlcoholLevel implements LevelConverter {
    BAIXO,MODERADO,ALTO;

    @Override
    public Enum convert(double abv) {
       return Stream.of(AlcoholLevel.values())
               .filter(alcoholLevel -> {
                   return switch (alcoholLevel) {
                       case BAIXO -> abv < 5;
                       case MODERADO -> abv >= 5 && abv < 8;
                       case ALTO -> abv >= 8;
                       default -> false;
                   };
               })
               .findFirst()
               .orElse(AlcoholLevel.BAIXO);
    }
}
