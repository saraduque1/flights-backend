package com.udea.Flights.repository;

import com.udea.Flights.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FareRepositoryTest {

    @Mock
    private IFareRepository iFareRepository;

    private Flight flight;

    private FlightClass flightClass;

    private Airline airline;

    private Airport airportOrigin;

    private Airport airportDestination;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        LocalDate departureDate = LocalDate.of(2024, 5, 15);
        LocalTime departureTime = LocalTime.of(10, 30);
        LocalDate arrivalDate = LocalDate.of(2024, 5, 16);
        LocalTime arrivalTime = LocalTime.of(14, 45);

        airline = new Airline(null, "Airline", "Country");
        airportOrigin = new Airport(null, "OriginAirport", "IAT", "ICAO", "City", "Country", "AirportType");
        airportDestination = new Airport(null, "DestinationAirport", "IAT", "ICAO", "City", "Country", "AirportType");
        flight = new Flight(null, "123", departureDate, departureTime, arrivalDate, arrivalTime, airline, airportOrigin, airportDestination);
        flightClass = new FlightClass(null, "NameTypeClass");
    }

    @Test
    void testFindFaresByFlightAndClass() {
        LocalDate departureDate = LocalDate.of(2024, 5, 15);
        LocalDate arrivalDate = LocalDate.of(2024, 5, 16);

        List<Fare> fares = Arrays.asList(
                new Fare(null, flight, flightClass, BigDecimal.valueOf(100.00)),
                new Fare(null, flight, flightClass, BigDecimal.valueOf(100.00))
        );

        when(iFareRepository.findByDatesAndCities(departureDate, arrivalDate, "city", "city")).thenReturn(fares);

        List<Fare> result = iFareRepository.findByDatesAndCities(departureDate, arrivalDate, "city", "city");
        assertEquals(2, result.size());
    }
}
