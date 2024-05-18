package com.udea.Flights.repository;

import com.udea.Flights.domain.model.Fare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IFareRepository extends JpaRepository<Fare, Long> {
    @Query("SELECT f FROM Fare f " +
            "JOIN f.idFlight fl " +
            "JOIN fl.idAirportOrigin ao " +
            "JOIN fl.idAirportDestination ad " +
            "WHERE fl.departureDate = :departureDate " +
            "AND fl.arrivalDate = :arrivalDate " +
            "AND ao.city = :originCity " +
            "AND ad.city = :destinationCity")
    List<Fare> findByDatesAndCities(@Param("departureDate") LocalDate departureDate,
                                    @Param("arrivalDate") LocalDate arrivalDate,
                                    @Param("originCity") String originCity,
                                    @Param("destinationCity") String destinationCity);
}