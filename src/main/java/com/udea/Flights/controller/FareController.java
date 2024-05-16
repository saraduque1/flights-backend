package com.udea.Flights.controller;

import com.udea.Flights.domain.dto.FareDTO;
import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.service.IFareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fares")
public class FareController {

    private final IFareService fareService;

    @Autowired
    public FareController(IFareService fareService) {
        this.fareService = fareService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<FareDTO>> getFaresByFlightClassName(
            @RequestParam String nameTypeClass) {

        List<FareDTO> fares = fareService.getFaresByFlightClassName(nameTypeClass);
        return ResponseEntity.ok(fares);
    }
}
