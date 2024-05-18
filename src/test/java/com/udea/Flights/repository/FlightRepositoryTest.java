package com.udea.Flights.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import com.udea.Flights.domain.model.Airline;
import com.udea.Flights.domain.model.Airport;
import com.udea.Flights.domain.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FlightRepositoryTest {

    @MockBean
    private IFlightRepository iFlightRepository;

    @Mock
    private Airline airline;

    @Mock
    private Airport airportOrigin;

    @Mock
    private Airport airportDestination;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        airline = new Airline(null, "Test Airline", "Test Country");
        airportOrigin = new Airport(null, "Origin Airport", "IAT", "ICAO", "City", "Country", "AirportType");
        airportDestination = new Airport(null, "Destination Airport", "IAT", "ICAO", "City", "Country", "AirportType");
    }

    @Test
    public void testFindFlightsByDatesAndCities() {
        LocalDate departureDate = LocalDate.of(2024, 5, 15);
        LocalTime departureTime = LocalTime.of(10, 30);
        LocalDate arrivalDate = LocalDate.of(2024, 5, 16);
        LocalTime arrivalTime = LocalTime.of(14, 45);


        List<Flight> flights = Arrays.asList(
                new Flight(null, "123", departureDate, departureTime, arrivalDate,  arrivalTime, airline, airportOrigin, airportDestination),
                new Flight(null, "456", departureDate, departureTime, arrivalDate,  arrivalTime, airline, airportOrigin, airportDestination)
        );

        when(iFlightRepository.findFlightsByDatesAndCities(departureDate, arrivalDate, "City", "City")).thenReturn(flights);

        List<Flight> result = iFlightRepository.findFlightsByDatesAndCities(departureDate, arrivalDate, "City", "City");

        assertThat(result).isEqualTo(flights);
    }
}

