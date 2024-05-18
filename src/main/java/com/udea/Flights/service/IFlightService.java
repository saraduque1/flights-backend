package com.udea.Flights.service;

import com.udea.Flights.domain.dto.FlightDTO;

import java.time.LocalDate;
import java.util.List;

public interface IFlightService {
    List<FlightDTO> searchFlightsByDatesAndCities(LocalDate departureDate, LocalDate arrivalDate, String originCity, String destinationCity);
}