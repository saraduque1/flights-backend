package com.udea.Flights.mapper;

import com.udea.Flights.domain.dto.AirportDTO;
import com.udea.Flights.domain.model.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class IAirportMapperImplTest {

    @InjectMocks
    private IAirportMapperImpl airportMapper;

    private Airport airport;
    private AirportDTO airportDTO;

    @BeforeEach
    void setUp() {
        airportMapper = new IAirportMapperImpl();

        airport = Airport.builder()
                .iataCode("Test Airport")
                .build();

        airportDTO = AirportDTO.builder()
                .iataCode("Test Airport DTO")
                .build();
    }

    @Test
    void testAirlineToAirlineDTO() {
        AirportDTO result = airportMapper.AirportToAirportDTO(airport);

        assertNotNull(result);
        assertEquals(airport.getIataCode(), result.getIataCode());
    }

    @Test
    void testAirlineDTOToAirline() {
        Airport result = airportMapper.AirportDTOToAirport(airportDTO);

        assertNotNull(result);
        assertEquals(airportDTO.getIataCode(), result.getIataCode());
    }
}
