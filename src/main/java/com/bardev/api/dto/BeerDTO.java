package com.bardev.api.dto;


import com.bardev.domain.entity.enums.AlcoholLevel;
import com.bardev.domain.entity.enums.BitternessLevel;
import com.bardev.domain.entity.enums.ColorLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeerDTO {


    private String id;

    private String name;


    private String description;

    private double price;

    private AlcoholLevel alcoholLevel;

    private BitternessLevel bitternessLevel;

    private ColorLevel colorLevel;

    public BeerDTO(String s, String name, String description, double a, double b, double c) {
        this.id = s;
        this.name = name;
        this.description = description;
        setAlcoholLevel(a);
        setBitternessLevel(b);
        setColorLevel(c);
    }

    public void setAlcoholLevel(double abv) {
        AlcoholLevel alcoholLevel = AlcoholLevel.BAIXO;
        this.alcoholLevel = (AlcoholLevel) alcoholLevel.convert(abv);
    }

    public void setBitternessLevel(double ibu) {
        BitternessLevel bitternessLevel = BitternessLevel.MODERADO;
        this.bitternessLevel = (BitternessLevel) bitternessLevel.convert(ibu);
    }

    public void setColorLevel(double ebc) {
        ColorLevel colorLevel = ColorLevel.AMBAR;
        this.colorLevel = (ColorLevel) colorLevel.convert(ebc);
    }
}
