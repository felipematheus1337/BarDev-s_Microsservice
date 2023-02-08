package com.bardev.api.client.response;

import lombok.Data;

@Data
public class BeerResponse {
    private Long id;
    private String name;
    private String description;
    private Long abv;
    private Long ibu;

    private Long ebc;
}
