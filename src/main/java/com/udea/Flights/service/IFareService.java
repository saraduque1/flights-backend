package com.udea.Flights.service;

import com.udea.Flights.domain.dto.FareDTO;
import java.util.List;

public interface IFareService {
    List<FareDTO> getFaresByFlightClassName(String nameTypeClass);
}