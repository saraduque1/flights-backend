package com.udea.Flights.mapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.udea.Flights.domain.dto.AirlineDTO;
import com.udea.Flights.domain.dto.AirportDTO;
import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.domain.model.Airline;
import com.udea.Flights.domain.model.Airport;
import com.udea.Flights.domain.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalTime;

@ExtendWith(MockitoExtension.class)
class IFlightMapperImplTest {

    @Mock
    private IAirlineMapper iAirlineMapper;

    @Mock
    private IAirportMapper iAirportMapper;

    @InjectMocks
    private IFlightMapperImpl flightMapper;

    private Flight flight;
    private FlightDTO flightDTO;

    @BeforeEach
    void setUp() {
        flight = Flight.builder()
                .idAirline(new Airline())
                .idAirportOrigin(new Airport())
                .idAirportDestination(new Airport())
                .departureTime(LocalTime.now())
                .arrivalTime(LocalTime.now().plusHours(2))
                .build();

        flightDTO = FlightDTO.builder()
                .airline(new AirlineDTO())
                .airportOrigin(new AirportDTO())
                .airportDestination(new AirportDTO())
                .departureTime(LocalTime.now())
                .arrivalTime(LocalTime.now().plusHours(2))
                .build();
    }

    @Test
    void testFlightToFlightDTO() {
        when(iAirlineMapper.airlineToAirlineDTO(any(Airline.class))).thenReturn(new AirlineDTO());
        when(iAirportMapper.AirportToAirportDTO(any(Airport.class))).thenReturn(new AirportDTO());

        FlightDTO result = flightMapper.flightToFlightDTO(flight);

        assertNotNull(result);
        assertEquals(flight.getDepartureTime(), result.getDepartureTime());
        assertEquals(flight.getArrivalTime(), result.getArrivalTime());
        assertNotNull(result.getAirline());
        assertNotNull(result.getAirportOrigin());
        assertNotNull(result.getAirportDestination());
        verify(iAirlineMapper).airlineToAirlineDTO(flight.getIdAirline());
        verify(iAirportMapper, times(2)).AirportToAirportDTO(any(Airport.class));
    }

    @Test
    void testFlightDTOToFlight() {
        when(iAirlineMapper.airlineDTOToAirline(any(AirlineDTO.class))).thenReturn(new Airline());
        when(iAirportMapper.AirportDTOToAirport(any(AirportDTO.class))).thenReturn(new Airport());

        Flight result = flightMapper.flightDTOToFlight(flightDTO);

        assertNotNull(result);
        assertEquals(flightDTO.getDepartureTime(), result.getDepartureTime());
        assertEquals(flightDTO.getArrivalTime(), result.getArrivalTime());
        assertNotNull(result.getIdAirline());
        assertNotNull(result.getIdAirportOrigin());
        assertNotNull(result.getIdAirportDestination());
        verify(iAirlineMapper).airlineDTOToAirline(flightDTO.getAirline());
        verify(iAirportMapper, times(2)).AirportDTOToAirport(any(AirportDTO.class));
    }
}

