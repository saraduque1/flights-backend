package com.udea.Flights.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FareDTO {
    private FlightDTO flight;
    private FlightClassDTO flightClass;
    private BigDecimal price;
}