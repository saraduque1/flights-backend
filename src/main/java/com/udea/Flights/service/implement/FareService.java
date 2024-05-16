package com.udea.Flights.service.implement;

import com.udea.Flights.domain.dto.FareDTO;
import com.udea.Flights.domain.model.Fare;
import com.udea.Flights.exception.ServiceException;
import com.udea.Flights.mapper.IFareMapper;
import com.udea.Flights.repository.IFareRepository;
import com.udea.Flights.service.IFareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<FareDTO> getFaresByFlightClassName(String nameTypeClass) {
        try {
            List<Fare> fares = fareRepository.findByFlightClassName(nameTypeClass);
            return fares.stream()
                    .map(fareMapper::fareToFareDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException("Error al buscar vuelos por fechas de salida y llegada", e);
        }
    }

}