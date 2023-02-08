package com.bardev.domain.entity.enums;

import com.bardev.domain.repository.LevelConverter;

import java.util.stream.Stream;


public enum BitternessLevel  implements LevelConverter {
    FRACO, MODERADO, FORTE;


    @Override
    public Enum convert(double ibu) {
        if(ibu < 30) {
            return BitternessLevel.FRACO;
        } else if(ibu > 30 && ibu < 40) {
            return BitternessLevel.MODERADO;
        } else {
            return BitternessLevel.FORTE;
        }
    }



}
