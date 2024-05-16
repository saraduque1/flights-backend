package com.udea.Flights.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa una clase de vuelo")
public class FlightClassDTO {

    @Schema(description = "Nombre de la clase de vuelo", example = "Económica")
    private String nameTypeClass;
}

