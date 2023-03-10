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

    @GetMapping(value = "{ibuGt}")
    List<BeerResponse> getBeerByIbuGreaterThan(@RequestParam(name = "ibu_gt") Integer ibuGt);

    @GetMapping(value = "{ibuLt}")
    List<BeerResponse> getBeerByIbuLessThan(@RequestParam(name = "ibu_lt") Integer ibuLt);

    @GetMapping(value = "{ebcGt}")
    List<BeerResponse> getBeerByEbcGreaterThan(@RequestParam(name = "ebc_gt") Integer ebcGt);

    @GetMapping(value = "{ebcLt}")
    List<BeerResponse> getBeerByEbcLessThan(@RequestParam(name = "ebc_lt") Integer ebcLt);





}
