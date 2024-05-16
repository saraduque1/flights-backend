package com.udea.Flights.mapper;

import com.udea.Flights.domain.dto.FareDTO;
import com.udea.Flights.domain.model.Fare;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {IFlightMapper.class, IFlightClassMapper.class})
public interface IFareMapper {
    @Mapping(source = "idFlight", target = "flight")
    @Mapping(source = "idFlightClass", target = "flightClass")
    FareDTO fareToFareDTO(Fare fare);

    @InheritInverseConfiguration
    Fare fareDTOToFare(FareDTO fareDTO);
}

