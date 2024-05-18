package com.udea.Flights.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa una tarifa")
public class FareDTO {
    @Schema(description = "Vuelo al que pertenece la tarifa")
    private FlightDTO flight;
    @Schema(description = "Clase de vuelo a la que pertenece la tarifa")
    private FlightClassDTO flightClass;
    @Schema(description = "Precio de la tarifa", example = "100000.00")
    private BigDecimal price;
}