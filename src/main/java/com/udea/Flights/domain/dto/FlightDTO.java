package com.udea.Flights.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa un vuelo")
public class FlightDTO {
    @Schema(description = "Hora de salida del vuelo", example = "23:59:59")
    private LocalTime departureTime;
    @Schema(description = "Hora de llegada del vuelo", example = "23:59:59")
    private LocalTime arrivalTime;
    @Schema(description = "Aerolínea encargada del vuelo")
    private AirlineDTO airline;
    @Schema(description = "Aeropuerto de origen")
    private AirportDTO airportOrigin;
    @Schema(description = "Aeropuerto de destino")
    private AirportDTO airportDestination;
}