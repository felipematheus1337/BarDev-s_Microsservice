package com.bardev.domain.entity.enums;

import com.bardev.domain.repository.LevelConverter;

import java.util.stream.Stream;


public enum BitternessLevel  implements LevelConverter {
    FRACO, MODERADO, FORTE;

    @Override
    public Enum convert(double ibu) {
        return Stream.of(BitternessLevel.values())
                .filter(bitternessLevel -> {
                    return switch (bitternessLevel) {
                        case FRACO -> ibu < 30;
                        case MODERADO -> ibu > 30 && ibu < 40;
                        case FORTE -> ibu > 40;
                        default -> false;
                    };
                })
                .findFirst()
                .orElse(BitternessLevel.MODERADO);
    }

}
