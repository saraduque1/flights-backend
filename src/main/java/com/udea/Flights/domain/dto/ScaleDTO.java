package com.udea.Flights.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScaleDTO {
    private FlightDTO flight;
    private AirportDTO airport;
    private Integer scaleOrder;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}