package com.bardev.domain.entity;


import com.bardev.domain.entity.enums.AlcoholLevel;
import com.bardev.domain.entity.enums.BitternessLevel;
import com.bardev.domain.entity.enums.ColorLevel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "beer")
public class Beer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;


    private String description;

    private double price;

    private AlcoholLevel alcoholLevel;

    private BitternessLevel bitternessLevel;

    private ColorLevel colorLevel;



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
