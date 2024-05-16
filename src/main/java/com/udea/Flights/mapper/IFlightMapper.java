package com.udea.Flights.mapper;

import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.domain.model.Flight;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {IAirlineMapper.class, IAirportMapper.class})
public interface IFlightMapper {
    @Mapping(source = "idAirline", target = "airline")
    @Mapping(source = "idAirportOrigin", target = "airportOrigin")
    @Mapping(source = "idAirportDestination", target = "airportDestination")
    FlightDTO flightToFlightDTO(Flight flight);

    @InheritInverseConfiguration
    Flight flightDTOToFlight(FlightDTO flightDTO);
}

