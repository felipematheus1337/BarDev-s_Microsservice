package com.bardev.domain.entity;


import com.bardev.domain.entity.enums.AlcoholLevel;
import com.bardev.domain.entity.enums.BitternessLevel;
import com.bardev.domain.entity.enums.ColorLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
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
        AlcoholLevel aLevel = AlcoholLevel.MODERADO;
        for (AlcoholLevel l : AlcoholLevel.values()) {
            if (l.convert(abv) != null) {
                aLevel = l;
                break;
            }
        }
        this.alcoholLevel = aLevel;
    }

    public void setBitternessLevel(double ibu) {
        BitternessLevel bLevel = BitternessLevel.MODERADO;
        for(BitternessLevel b: BitternessLevel.values()) {
            if (b.convert(ibu) != null) {
                bLevel = b;
                break;
            }
        }
        this.bitternessLevel = bLevel;
    }

    public void setColorLevel(double ebc) {
       ColorLevel cLevel = ColorLevel.AMBAR;
       for(ColorLevel c: ColorLevel.values()) {
           if(c.convert(ebc) != null) {
               cLevel = c;
               break;
           }
       }
       this.colorLevel = cLevel;
    }
}
