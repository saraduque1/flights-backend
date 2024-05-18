package com.udea.Flights.service;

import com.udea.Flights.domain.dto.FareDTO;
import com.udea.Flights.domain.model.Fare;
import com.udea.Flights.mapper.IFareMapper;
import com.udea.Flights.repository.IFareRepository;
import com.udea.Flights.service.implement.FareService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FareServiceTest {

    @Mock
    private IFareRepository fareRepository;

    @Mock
    private IFareMapper fareMapper;

    @InjectMocks
    private FareService fareService;

    @Test
    void testSearchFlightsByDatesAndCities() {
        LocalDate departureDate = LocalDate.of(2024, 5, 17);
        LocalDate arrivalDate = LocalDate.of(2024, 5, 18);
        String originCity = "OriginCity";
        String destinationCity = "DestinationCity";

        Fare fare = new Fare();
        FareDTO fareDTO = new FareDTO();

        List<Fare> fares = Arrays.asList(fare);
        when(fareRepository.findByDatesAndCities(departureDate, arrivalDate, originCity, destinationCity)).thenReturn(fares);
        when(fareMapper.fareToFareDTO(fare)).thenReturn(fareDTO);

        List<FareDTO> result = fareService.searchFlightsByDatesAndCities(departureDate, arrivalDate, originCity, destinationCity);

        assertEquals(1, result.size());
        assertEquals(fareDTO, result.get(0));
    }
}

