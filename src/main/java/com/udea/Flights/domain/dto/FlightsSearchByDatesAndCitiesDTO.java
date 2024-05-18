package com.udea.Flights.domain.dto;

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
public class FlightsSearchByDatesAndCitiesDTO {
    @NotNull
    private LocalDate departureDate;
    @NotNull
    private LocalDate arrivalDate;
    @NotNull
    private String originCity;
    @NotNull
    private String destinationCity;
}
