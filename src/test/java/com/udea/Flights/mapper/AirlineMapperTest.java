package com.udea.Flights.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.udea.Flights.domain.dto.AirlineDTO;
import com.udea.Flights.domain.model.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IAirlineMapperImplTest {

    @InjectMocks
    private IAirlineMapperImpl airlineMapper;

    private Airline airline;
    private AirlineDTO airlineDTO;

    @BeforeEach
    void setUp() {
        airlineMapper = new IAirlineMapperImpl();

        airline = Airline.builder()
                .airlineName("Test Airline")
                .build();

        airlineDTO = AirlineDTO.builder()
                .airlineName("Test Airline DTO")
                .build();
    }

    @Test
    void testAirlineToAirlineDTO() {
        AirlineDTO result = airlineMapper.airlineToAirlineDTO(airline);

        assertNotNull(result);
        assertEquals(airline.getAirlineName(), result.getAirlineName());
    }

    @Test
    void testAirlineDTOToAirline() {
        Airline result = airlineMapper.airlineDTOToAirline(airlineDTO);

        assertNotNull(result);
        assertEquals(airlineDTO.getAirlineName(), result.getAirlineName());
    }
}

