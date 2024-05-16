package com.udea.Flights.mapper;

import com.udea.Flights.domain.dto.AirportDTO;
import com.udea.Flights.domain.model.Airport;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IAirportMapper {
    AirportDTO AirportToAirportDTO(Airport airport);

    @InheritInverseConfiguration
    Airport AirportDTOToAirport(AirportDTO airportDTO);
}
