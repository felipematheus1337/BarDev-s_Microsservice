package com.bardev.domain.service.menu;

import com.bardev.api.dto.BeerDTO;

import java.util.List;

public interface MenuService {

    List<BeerDTO> getHigher();
    List<BeerDTO> getModerate();

    List<BeerDTO> getWeaker();

}
