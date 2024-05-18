package com.udea.Flights.controller;

import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.domain.dto.FlightsSearchByDatesAndCitiesDTO;
import com.udea.Flights.service.IFlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v3/flights")
@Tag(name = "Gestión de vuelos", description = "API para gestionar vuelos")
public class FlightController {

    private final IFlightService flightService;

    @Autowired
    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @Operation(summary = "Buscar vuelos por fechas y ciudades", description = "Busque vuelos según las fechas de salida y llegada, y las ciudades de origen y destino")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found flights", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/search")
    public ResponseEntity<List<FlightDTO>> searchFlightsByDatesAndCities(@Valid @RequestBody FlightsSearchByDatesAndCitiesDTO searchRequest) {
        LocalDate departureDate = searchRequest.getDepartureDate();
        LocalDate arrivalDate = searchRequest.getArrivalDate();

        List<FlightDTO> flights = flightService.searchFlightsByDatesAndCities(departureDate, arrivalDate, searchRequest.getOriginCity(), searchRequest.getDestinationCity());
        return ResponseEntity.ok(flights);
    }
}

