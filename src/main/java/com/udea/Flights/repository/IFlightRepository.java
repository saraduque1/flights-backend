package com.udea.Flights.repository;

import com.udea.Flights.domain.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f " +
            "JOIN f.idAirportOrigin ao " +
            "JOIN f.idAirportDestination ad " +
            "WHERE f.departureDate = :departureDate " +
            "AND f.arrivalDate = :arrivalDate " +
            "AND ao.city = :originCity " +
            "AND ad.city = :destinationCity")
    List<Flight> findFlightsByDatesAndCities(@Param("departureDate") LocalDate departureDate,
                                                            @Param("arrivalDate") LocalDate arrivalDate,
                                                            @Param("originCity") String originCity,
                                                            @Param("destinationCity") String destinationCity);
}