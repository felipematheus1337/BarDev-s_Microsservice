package com.bardev.domain.service.internal.impl;

import com.bardev.api.dto.BeerDTO;
import com.bardev.api.mapper.BeerMapper;
import com.bardev.domain.entity.Beer;
import com.bardev.domain.repository.BeerRepository;
import com.bardev.domain.service.internal.BeerInternalService;
import com.bardev.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BeerInternalServiceImpl implements BeerInternalService {

    private final BeerRepository repository;
    private final BeerMapper mapper;
    @Override
    public List<BeerDTO> findALL() {
        return repository.findAll()
                .stream()
                .map(this.mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<BeerDTO> getOneBeerById(String id) {
        var beer = repository.findById(id);

        if(beer.isEmpty()) {
            throw new BusinessException("Beer not found with that id!");
        }

        return beer.map(this.mapper::toDTO);
    }

    @Override
    public void deleteBeer(String id) {
        var beer = repository.findById(id);

        if(beer.isEmpty()) {
            throw new BusinessException("Beer not found with that id!");
        }

        repository.deleteById(id);

    }

    @Override
    public BeerDTO createBeer(Beer beer) {
       return Stream.of(repository.insert(beer))
               .map(this.mapper::toDTO).findFirst().get();
    }

    @Override
    public BeerDTO updateAnBeer(String id, Beer beer) {
        var beerExists = repository.findById(id);

        if(beerExists.isEmpty()) {
            throw new BusinessException("Beer not found with that id!");
        }

        beer.setId(id);

        return Stream.of(repository.insert(beer))
                .map(this.mapper::toDTO)
                .findFirst()
                .get();

    }
}
