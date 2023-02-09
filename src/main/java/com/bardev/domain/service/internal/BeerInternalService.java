package com.bardev.domain.service.internal;

import com.bardev.api.dto.BeerDTO;
import com.bardev.domain.entity.Beer;

import java.util.List;
import java.util.Optional;

public interface BeerInternalService {


    List<BeerDTO> findALL();

    Optional<BeerDTO> getOneBeerById(String id);

    void deleteBeer(String id);

    BeerDTO createBeer(Beer beer);

    BeerDTO updateAnBeer(String id, Beer beer);
}
