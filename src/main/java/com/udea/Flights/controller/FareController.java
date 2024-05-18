package com.udea.Flights.controller;

import com.udea.Flights.domain.dto.FareDTO;
import com.udea.Flights.domain.dto.FlightsSearchByDatesAndCitiesDTO;
import com.udea.Flights.service.IFareService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v3/api/fares")
@Tag(name = "Gestión de tarifas de vuelos", description = "API para gestionar tarifas")
public class FareController {

    private final IFareService fareService;

    @Autowired
    public FareController(IFareService fareService) {
        this.fareService = fareService;
    }

    @Operation(summary = "Buscar tarifas por fechas y ciudades", description = "Busque tarifas según las fechas de salida y llegada, y las ciudades de origen y destino")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found fares", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FareDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/search")
    public ResponseEntity<List<FareDTO>> searchFlightsByDatesAndCities(@Valid @RequestBody FlightsSearchByDatesAndCitiesDTO searchRequest) {
        LocalDate departureDate = searchRequest.getDepartureDate();
        LocalDate arrivalDate = searchRequest.getArrivalDate();

        List<FareDTO> fares = fareService.searchFlightsByDatesAndCities(departureDate, arrivalDate, searchRequest.getOriginCity(), searchRequest.getDestinationCity());
        return ResponseEntity.ok(fares);
    }
}
