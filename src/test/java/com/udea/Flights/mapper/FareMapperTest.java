package com.udea.Flights.mapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.udea.Flights.domain.dto.FareDTO;
import com.udea.Flights.domain.dto.FlightClassDTO;
import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.domain.model.Fare;
import com.udea.Flights.domain.model.Flight;
import com.udea.Flights.domain.model.FlightClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class IFareMapperImplTest {

    @Mock
    private IFlightMapper iFlightMapper;

    @Mock
    private IFlightClassMapper iFlightClassMapper;

    @InjectMocks
    private IFareMapperImpl fareMapper;

    private Fare fare;
    private FareDTO fareDTO;

    @BeforeEach
    void setUp() {
        fare = Fare.builder()
                .idFlight(new Flight())
                .idFlightClass(new FlightClass())
                .price(new BigDecimal("100.00"))
                .build();

        fareDTO = FareDTO.builder()
                .flight(new FlightDTO())
                .flightClass(new FlightClassDTO())
                .price(new BigDecimal("100.00"))
                .build();
    }

    @Test
    void testFareToFareDTO() {
        when(iFlightMapper.flightToFlightDTO(any(Flight.class))).thenReturn(new FlightDTO());
        when(iFlightClassMapper.flightClassToFlightClassDTO(any(FlightClass.class))).thenReturn(new FlightClassDTO());

        FareDTO result = fareMapper.fareToFareDTO(fare);

        assertNotNull(result);
        assertEquals(fare.getPrice(), result.getPrice());
        assertNotNull(result.getFlight());
        assertNotNull(result.getFlightClass());
        verify(iFlightMapper).flightToFlightDTO(fare.getIdFlight());
        verify(iFlightClassMapper).flightClassToFlightClassDTO(fare.getIdFlightClass());
    }

    @Test
    void testFareDTOToFare() {
        when(iFlightMapper.flightDTOToFlight(any(FlightDTO.class))).thenReturn(new Flight());
        when(iFlightClassMapper.flightClassDTOToFlightClass(any(FlightClassDTO.class))).thenReturn(new FlightClass());

        Fare result = fareMapper.fareDTOToFare(fareDTO);

        assertNotNull(result);
        assertEquals(fareDTO.getPrice(), result.getPrice());
        assertNotNull(result.getIdFlight());
        assertNotNull(result.getIdFlightClass());
        verify(iFlightMapper).flightDTOToFlight(fareDTO.getFlight());
        verify(iFlightClassMapper).flightClassDTOToFlightClass(fareDTO.getFlightClass());
    }
}




