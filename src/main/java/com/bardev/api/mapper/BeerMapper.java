package com.bardev.api.mapper;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeerMapper {

    private final ModelMapper modelMapper;

 
}
