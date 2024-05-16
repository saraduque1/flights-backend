package com.udea.Flights.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa una aerolínea")
public class AirlineDTO {

    @Schema(description = "Nombre de la aerolínea", example = "Avianca")
    private String airlineName;
}