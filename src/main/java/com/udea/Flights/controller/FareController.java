package com.udea.Flights.controller;

import com.udea.Flights.domain.dto.FareDTO;
import com.udea.Flights.domain.dto.FlightsSearchByDatesAndCitiesDTO;
import com.udea.Flights.service.IFareService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v3/api/fares")
public class FareController {

    private final IFareService fareService;

    @Autowired
    public FareController(IFareService fareService) {
        this.fareService = fareService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<FareDTO>> searchFlightsByDatesAndCities(@Valid @RequestBody FlightsSearchByDatesAndCitiesDTO searchRequest) {
        LocalDate departureDate = searchRequest.getDepartureDate();
        LocalDate arrivalDate = searchRequest.getArrivalDate();

        List<FareDTO> fares = fareService.searchFlightsByDatesAndCities(departureDate, arrivalDate, searchRequest.getOriginCity(), searchRequest.getDestinationCity());
        return ResponseEntity.ok(fares);
    }
}
