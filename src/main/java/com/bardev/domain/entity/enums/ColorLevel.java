package com.bardev.domain.entity.enums;

import com.bardev.domain.repository.LevelConverter;

import java.util.stream.Stream;

public enum ColorLevel implements LevelConverter {
    CLARA, AMBAR, ESCURA;

    @Override
    public Enum convert(double ebc) {

        if (ebc < 12) {
            return ColorLevel.CLARA;
        } else if (ebc > 12 && ebc <= 33) {
            return ColorLevel.AMBAR;
        } else {
            return ColorLevel.ESCURA;
        }
    }

}
