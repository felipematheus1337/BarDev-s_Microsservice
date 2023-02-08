package com.bardev.domain.entity;


import com.bardev.domain.entity.enums.AlcoholLevel;
import com.bardev.domain.entity.enums.BitternessLevel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

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

    private BitternessLevel colorLevel;






}
