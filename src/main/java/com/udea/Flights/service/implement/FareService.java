package com.udea.Flights.service.implement;

import com.udea.Flights.domain.dto.FareDTO;
import com.udea.Flights.domain.dto.FlightDTO;
import com.udea.Flights.domain.model.Fare;
import com.udea.Flights.domain.model.Flight;
import com.udea.Flights.exception.ServiceException;
import com.udea.Flights.mapper.IFareMapper;
import com.udea.Flights.repository.IFareRepository;
import com.udea.Flights.service.IFareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FareService implements IFareService {

    private final IFareRepository fareRepository;
    private final IFareMapper fareMapper;

    @Autowired
    public FareService(IFareRepository fareRepository, IFareMapper fareMapper) {
        this.fareRepository = fareRepository;
        this.fareMapper = fareMapper;
    }


    @Override
    public List<FareDTO> searchFlightsByDatesAndCities(LocalDate departureDate, LocalDate arrivalDate, String originCity, String destinationCity) {
        try {
            List<Fare> fares = fareRepository.findByDatesAndCities(departureDate, arrivalDate, originCity, destinationCity);
            return fares.stream()
                    .map(fareMapper::fareToFareDTO)
                    .toList();
        } catch (Exception e) {
            throw new ServiceException("Error al buscar vuelos por fechas de salida y llegada", e);
        }
    }
}