package com.bardev.domain.entity.enums;

import com.bardev.domain.repository.LevelConverter;

import java.util.stream.Stream;

public enum AlcoholLevel implements LevelConverter {
    BAIXO,MODERADO,ALTO;

    @Override
    public Enum convert(double abv) {
        if(abv < 5) {
            return AlcoholLevel.BAIXO;
        } else if(abv > 5 && abv < 8) {
            return AlcoholLevel.MODERADO;
        } else {
            return AlcoholLevel.ALTO;
        }
    }
}
