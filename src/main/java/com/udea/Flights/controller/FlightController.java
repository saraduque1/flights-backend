package com.udea.Flights.controller;

import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final IFlightService flightService;

    @Autowired
    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDTO>> searchByDepartureDateAndArrivalDate(
            @RequestParam("departureDate") String departureDateStr,
            @RequestParam("arrivalDate") String arrivalDateStr) {

        LocalDateTime departureDate = LocalDateTime.parse(departureDateStr);
        LocalDateTime arrivalDate = LocalDateTime.parse(arrivalDateStr);

        List<FlightDTO> flights = flightService.searchByDepartureDateAndArrivalDate(departureDate, arrivalDate);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/search/byFlightNumber")
    public ResponseEntity<List<FlightDTO>> searchByFlightNumber(@RequestParam("flightNumber") String flightNumber) {
        List<FlightDTO> flights = flightService.searchByFlightNumber(flightNumber);
        return ResponseEntity.ok(flights);
    }
}
