package com.udea.Flights.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa una escala")
public class ScaleDTO {
    @Schema(description = "Vuelo al que pertenece la escala")
    private FlightDTO flight;
    @Schema(description = "Aeropuerto de la escala")
    private AirportDTO airport;
    @Schema(description = "Numero de la escala", example = "1")
    private Integer scaleOrder;
    @Schema(description = "Fecha de llegada a la escala", example = "2021-10-10T10:00:00")
    private LocalDateTime checkIn;
    @Schema(description = "Fecha de salida de la escala", example = "2021-10-10T10:30:00")
    private LocalDateTime checkOut;
}