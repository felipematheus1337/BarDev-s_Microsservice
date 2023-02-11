package com.bardev.api.controller;

import com.bardev.domain.service.menu.impl.MenuAlcoholServiceImpl;
import com.bardev.domain.service.menu.impl.MenuBitterServiceImpl;
import com.bardev.domain.service.menu.impl.MenuColorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class MenuControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ModelMapper modelMapper;

    @Mock
    MenuAlcoholServiceImpl menuAlcoholService;

    @Autowired
    MenuBitterServiceImpl menuBitterService;

    @Autowired
    MenuColorServiceImpl menuColorService;


    @Test
    void getWithHigherAlcoholPercentage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/alcool/maior"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getWithModerateAlcoholPercentage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/alcool/moderado"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getWithWeakerAlcoholPercentage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/alcool/menor"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getWithHigherBitter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/bitter/maior"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getWithModerateBitter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/bitter/moderado"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getWithWeakerBitter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/bitter/menor"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getWithHigherColor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/color/escura"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getWithModerateColor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/color/amber"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getWithLighterColor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/color/clara"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}