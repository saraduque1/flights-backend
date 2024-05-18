package com.udea.Flights.controller;

import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.domain.dto.FlightsSearchByDatesAndCitiesDTO;
import com.udea.Flights.service.IFlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v3/flights")
public class FlightController {

    private final IFlightService flightService;

    @Autowired
    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<FlightDTO>> searchFlightsByDatesAndCities(@Valid @RequestBody FlightsSearchByDatesAndCitiesDTO searchRequest) {
        LocalDate departureDate = searchRequest.getDepartureDate();
        LocalDate arrivalDate = searchRequest.getArrivalDate();

        List<FlightDTO> flights = flightService.searchFlightsByDatesAndCities(departureDate, arrivalDate, searchRequest.getOriginCity(), searchRequest.getDestinationCity());
        return ResponseEntity.ok(flights);
    }
}
