package com.bardev.api.client.repository;


import com.bardev.api.client.response.BeerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "BeerClient", url = "https://api.punkapi.com/v2/beers")
public interface BeerClient {

    @GetMapping(value = "/random")
    List<BeerResponse> getRandomBeer();

    @GetMapping(value = "/{id}")
    List<BeerResponse> getBeerById(@PathVariable("id") Long id);

    @GetMapping(value = "{abvGt}")
    List<BeerResponse> getBeerByAbvGreaterThan(@RequestParam(name = "abv_gt") Integer abvGt);

    @GetMapping(value = "{abvLt}")
    List<BeerResponse> getBeerByAbvLessThan(@RequestParam(name = "abv_lt") Integer abvLt);
}
