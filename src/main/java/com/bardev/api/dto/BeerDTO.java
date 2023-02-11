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




}
