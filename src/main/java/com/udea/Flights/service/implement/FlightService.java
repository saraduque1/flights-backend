package com.udea.Flights.service.implement;

import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.domain.model.Flight;
import com.udea.Flights.exception.ServiceException;
import com.udea.Flights.mapper.IFlightMapper;
import com.udea.Flights.repository.IFlightRepository;
import com.udea.Flights.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService {

    private final IFlightRepository flightRepository;
    private final IFlightMapper flightMapper;

    @Autowired
    public FlightService(IFlightRepository flightRepository, IFlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public List<FlightDTO> searchByDepartureDateAndArrivalDate(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        try {
            List<Flight> flights = flightRepository.findByDepartureDateAndArrivalDate(departureDate, arrivalDate);
            return flights.stream()
                    .map(flightMapper::flightToFlightDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException("Error al buscar vuelos por fechas de salida y llegada", e);
        }
    }



    @Override
    public List<FlightDTO> searchByFlightNumber(String flightNumber) {
        try {
            List<Flight> flights = flightRepository.findByFlightNumber(flightNumber);
            return flights.stream()
                    .map(flightMapper::flightToFlightDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException("Error al buscar vuelos por número de vuelo", e);
        }
    }
}


