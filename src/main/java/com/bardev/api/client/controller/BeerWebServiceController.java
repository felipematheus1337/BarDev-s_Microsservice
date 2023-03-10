package com.bardev.api.client.controller;

import com.bardev.api.client.response.BeerResponse;
import com.bardev.api.client.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/beer")
public class BeerWebServiceController {

    private final BeerService beerService;

    @GetMapping("/{id}")
    public List<BeerResponse> buscarPorId(@PathVariable Long id) {
        return beerService.getBeerById(id);
    }

    @GetMapping()
    public List<BeerResponse> getRandomBeer() {
        return beerService.getRandomBeer();
    }

    @GetMapping("/abv/maior{abvGt}")
    public List<BeerResponse> getAbvGreater(@RequestParam(name = "abv_gt") Integer abvGt) {
        return beerService.getGreaterAbv(abvGt);
    }

    @GetMapping("/abv/menor{abvLt}")
    public List<BeerResponse> getAbvLesser(@RequestParam(name = "abv_lt") Integer abvLt) {
        return beerService.getLesserAbv(abvLt);
    }

    @GetMapping("/ibu/maior{ibuGt}")
    public List<BeerResponse> getIbuGreater(@RequestParam(name = "ibu_gt") Integer ibuGt) {
        return beerService.getGreaterIbu(ibuGt);
    }

    @GetMapping("/ibu/menor{ibuLt}")
    public List<BeerResponse> getIbuLesser(@RequestParam(name = "ibu_lt") Integer ibuLt) {
        return beerService.getLesserIbu(ibuLt);
    }

    @GetMapping("/ebc/maior{ebcGt}")
    public List<BeerResponse> getEbcGreater(@RequestParam(name = "ebc_gt") Integer ebcGt) {
        return beerService.getGreaterEbc(ebcGt);
    }

    @GetMapping("/ebc/menor{ebcLt}")
    public List<BeerResponse> getEbcLesser(@RequestParam(name = "ebc_lt") Integer ebcLt) {
        return beerService.getLesserEbc(ebcLt);
    }
}
