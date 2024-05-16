package com.udea.Flights.repository;

import com.udea.Flights.domain.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f WHERE f.departureDate = :departureDate AND f.arrivalDate = :arrivalDate")
    List<Flight> findByDepartureDateAndArrivalDate(@Param("departureDate") LocalDateTime departureDate, @Param("arrivalDate") LocalDateTime arrivalDate);

    @Query("SELECT f FROM Flight f WHERE f.flightNumber = :flightNumber")
    List<Flight> findByFlightNumber(@Param("flightNumber") String flightNumber);
}