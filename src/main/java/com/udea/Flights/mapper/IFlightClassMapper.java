package com.udea.Flights.mapper;


import com.udea.Flights.domain.dto.FlightClassDTO;
import com.udea.Flights.domain.model.FlightClass;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IFlightClassMapper {
    FlightClassDTO flightClassToFlightClassDTO(FlightClass flightClass);

    @InheritInverseConfiguration
    FlightClass flightClassDTOToFlightClass(FlightClassDTO flightClassDTO);
}
