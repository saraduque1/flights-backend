package com.udea.Flights.repository;

import com.udea.Flights.domain.model.Fare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFareRepository extends JpaRepository<Fare, Long> {

    @Query("SELECT f FROM Fare f JOIN f.idFlightClass fc WHERE fc.nameTypeClass = :nameTypeClass")
    List<Fare> findByFlightClassName(@Param("nameTypeClass") String nameTypeClass);
}