package com.udea.Flights.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.Flights.domain.dto.FareDTO;
import com.udea.Flights.domain.dto.FlightsSearchByDatesAndCitiesDTO;
import com.udea.Flights.service.IFareService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FareControllerTest {

    @Mock
    private IFareService fareService;

    @InjectMocks
    private FareController fareController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(fareController).build();
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void testSearchFlightsByDatesAndCities() throws Exception {
        LocalDate departureDate = LocalDate.of(2024, 5, 17);
        LocalDate arrivalDate = LocalDate.of(2024, 5, 18);
        String originCity = "OriginCity";
        String destinationCity = "DestinationCity";

        FlightsSearchByDatesAndCitiesDTO searchRequest = new FlightsSearchByDatesAndCitiesDTO();
        searchRequest.setDepartureDate(departureDate);
        searchRequest.setArrivalDate(arrivalDate);
        searchRequest.setOriginCity(originCity);
        searchRequest.setDestinationCity(destinationCity);

        List<FareDTO> fareDTOs = Arrays.asList(new FareDTO());
        when(fareService.searchFlightsByDatesAndCities(departureDate, arrivalDate, originCity, destinationCity)).thenReturn(fareDTOs);

        mockMvc.perform(post("/v3/api/fares/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}

