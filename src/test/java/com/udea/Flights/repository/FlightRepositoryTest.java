package com.udea.Flights.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
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
    public void testFindByDepartureDateAndArrivalDate() {
        LocalDateTime departureDate = LocalDateTime.of(2024, 5, 15, 10, 30);
        LocalDateTime arrivalDate = LocalDateTime.of(2024, 5, 16, 14, 45);

        List<Flight> flights = Arrays.asList(
                new Flight(null, "123", departureDate, arrivalDate, airline, airportOrigin, airportDestination),
                new Flight(null, "456", departureDate, arrivalDate, airline, airportOrigin, airportDestination)
        );

        when(iFlightRepository.findByDepartureDateAndArrivalDate(departureDate, arrivalDate)).thenReturn(flights);

        List<Flight> result = iFlightRepository.findByDepartureDateAndArrivalDate(departureDate, arrivalDate);

        assertThat(result).isEqualTo(flights);
    }

    @Test
    public void testFindByFlightNumber() {
        String flightNumber = "123";

        List<Flight> flights = Arrays.asList(
                new Flight(null, flightNumber, LocalDateTime.of(2024, 5, 15, 10, 30), LocalDateTime.of(2024, 5, 16, 14, 45), airline, airportOrigin, airportDestination)
        );

        when(iFlightRepository.findByFlightNumber(flightNumber)).thenReturn(flights);

        List<Flight> result = iFlightRepository.findByFlightNumber(flightNumber);

        assertThat(result).isEqualTo(flights);
    }
}

