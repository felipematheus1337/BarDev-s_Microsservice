package com.bardev.domain.entity.enums;

import com.bardev.domain.repository.LevelConverter;

import java.util.stream.Stream;

public enum ColorLevel implements LevelConverter {
    CLARA, AMBAR, ESCURA;

    @Override
    public Enum convert(double value) {
        return Stream.of(ColorLevel.values())
                .filter(colorLevel -> {
                    return switch (colorLevel) {
                        case CLARA -> value < 12;
                        case AMBAR -> value > 12 && value <= 33;
                        case ESCURA -> value > 33;
                        default -> false;
                    };
                })
                .findFirst()
                .orElse(ColorLevel.AMBAR);
    }
}
