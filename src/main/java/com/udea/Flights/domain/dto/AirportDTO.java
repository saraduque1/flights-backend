package com.udea.Flights.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa un aeropuerto")
public class AirportDTO {

    @Schema(description = "Nombre del aeropuerto", example = "BOG")
    private String iataCode;
}
