package com.bardev.api.client.response;

import lombok.Data;

@Data
public class BeerResponse {
    private Long id;
    private String name;
    private String description;
    private Double abv = 0.0;
    private Double ibu = 0.0;

    private Double ebc = 0.0;

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        if(abv == null) {
            this.abv = 0.0;
        }
        this.abv = abv;
    }

    public Double getIbu() {
        if(ibu == null) {
            return 0.0;
        }
        return ibu;
    }

    public void setIbu(Double ibu) {
        if(ibu == null) {
            this.ibu = 0.0;
        }
        this.ibu = ibu;
    }

    public Double getEbc() {
        return ebc;
    }

    public void setEbc(Double ebc) {
        if(ebc == null) {
            this.ebc = 0.0;
        }
        this.ebc = ebc;
    }
}
