package com.udea.Flights.service;

import com.udea.Flights.domain.dto.FlightDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IFlightService {
    List<FlightDTO> searchByDepartureDateAndArrivalDate(LocalDateTime departureDate, LocalDateTime arrivalDate);

    List<FlightDTO> searchByFlightNumber(String flightNumber);
}