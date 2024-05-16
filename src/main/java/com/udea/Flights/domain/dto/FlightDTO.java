package com.udea.Flights.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa un vuelo")
public class FlightDTO {
    @Schema(description = "Fecha de salida", example = "2021-12-31T23:59:59")
    private LocalDateTime departureDate;
    @Schema(description = "Fecha de llegada", example = "2021-12-31T23:59:59")
    private LocalDateTime arrivalDate;
    @Schema(description = "Aerolinea", example = "Avianca")
    private AirlineDTO airline;
    @Schema(description = "Aeropuerto de origen", example = "BOG")
    private AirportDTO airportOrigin;
    @Schema(description = "Aeropuerto de destino", example = "MDE")
    private AirportDTO airportDestination;
}