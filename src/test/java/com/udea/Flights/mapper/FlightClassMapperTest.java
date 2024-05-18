package com.udea.Flights.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.udea.Flights.domain.dto.FlightClassDTO;
import com.udea.Flights.domain.model.FlightClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IFlightClassMapperImplTest {

    @InjectMocks
    private IFlightClassMapperImpl flightClassMapper;

    private FlightClass flightClass;
    private FlightClassDTO flightClassDTO;

    @BeforeEach
    void setUp() {
        flightClassMapper = new IFlightClassMapperImpl();

        flightClass = FlightClass.builder()
                .nameTypeClass("Business")
                .build();

        flightClassDTO = FlightClassDTO.builder()
                .nameTypeClass("Economy")
                .build();
    }

    @Test
    void testFlightClassToFlightClassDTO() {
        FlightClassDTO result = flightClassMapper.flightClassToFlightClassDTO(flightClass);

        assertNotNull(result);
        assertEquals(flightClass.getNameTypeClass(), result.getNameTypeClass());
    }

    @Test
    void testFlightClassDTOToFlightClass() {
        FlightClass result = flightClassMapper.flightClassDTOToFlightClass(flightClassDTO);

        assertNotNull(result);
        assertEquals(flightClassDTO.getNameTypeClass(), result.getNameTypeClass());
    }
}

