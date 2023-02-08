package com.bardev.api.client.service;


import com.bardev.api.client.repository.BeerClient;
import com.bardev.api.client.response.BeerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerService {

    private final BeerClient beerClient;
    public List<BeerResponse> getBeerById(Long id) {
        return beerClient.getBeerById(id);
    }

    public List<BeerResponse> getRandomBeer() {
        return beerClient.getRandomBeer();
    }

    public List<BeerResponse> getGreaterAbv(Integer abv) {
        return beerClient.getBeerByAbvGreaterThan(abv);
    }

    public List<BeerResponse> getLesserAbv(Integer abvLt) {
        return beerClient.getBeerByAbvLessThan(abvLt);
    }

    public List<BeerResponse> getGreaterIbu(Integer ibuGt) {
        return beerClient.getBeerByIbuGreaterThan(ibuGt);
    }

    public List<BeerResponse> getLesserIbu(Integer ibuLt) {
        return beerClient.getBeerByIbuLessThan(ibuLt);
    }

    public List<BeerResponse> getGreaterEbc(Integer ebcGt) {
        return beerClient.getBeerByEbcGreaterThan(ebcGt);
    }

    public List<BeerResponse> getLesserEbc(Integer ebcLt) {
        return beerClient.getBeerByEbcLessThan(ebcLt);
    }
}
