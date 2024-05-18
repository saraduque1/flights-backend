package com.udea.Flights.service;

import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.domain.model.Flight;
import com.udea.Flights.mapper.IFlightMapper;
import com.udea.Flights.repository.IFlightRepository;
import com.udea.Flights.service.implement.FlightService;
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
public class FlightServiceTest {

    @Mock
    private IFlightRepository flightRepository;

    @Mock
    private IFlightMapper flightMapper;

    @InjectMocks
    private FlightService flightService;

    @Test
    void testSearchFlightsByDatesAndCities() {
        LocalDate departureDate = LocalDate.of(2024, 5, 17);
        LocalDate arrivalDate = LocalDate.of(2024, 5, 18);
        String originCity = "OriginCity";
        String destinationCity = "DestinationCity";

        Flight flight = new Flight();
        FlightDTO flightDTO = new FlightDTO();

        List<Flight> flights = Arrays.asList(flight);
        when(flightRepository.findFlightsByDatesAndCities(departureDate, arrivalDate, originCity, destinationCity)).thenReturn(flights);
        when(flightMapper.flightToFlightDTO(flight)).thenReturn(flightDTO);

        List<FlightDTO> result = flightService.searchFlightsByDatesAndCities(departureDate, arrivalDate, originCity, destinationCity);

        assertEquals(1, result.size());
        assertEquals(flightDTO, result.get(0));

    }
}
