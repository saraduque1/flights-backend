package com.udea.Flights.mapper;

import com.udea.Flights.domain.dto.AirlineDTO;
import com.udea.Flights.domain.model.Airline;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IAirlineMapper {
    AirlineDTO airlineToAirlineDTO(Airline airline);

    @InheritInverseConfiguration
    Airline airlineDTOToAirline(AirlineDTO airlineDTO);
}
