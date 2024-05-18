package com.udea.Flights.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa los criterios de búsqueda de vuelos por fechas y ciudades")
public class FlightsSearchByDatesAndCitiesDTO {

    @NotNull
    @Schema(description = "Fecha de salida", example = "2024-06-01")
    private LocalDate departureDate;

    @NotNull
    @Schema(description = "Fecha de llegada", example = "2024-06-15")
    private LocalDate arrivalDate;

    @NotNull
    @Schema(description = "Ciudad de origen", example = "Bogotá")
    private String originCity;

    @NotNull
    @Schema(description = "Ciudad de destino", example = "Medellín")
    private String destinationCity;
}

