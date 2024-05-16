package com.udea.Flights.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airport", nullable = false)
    private Integer idAirport;

    @Column(name = "airport_name", nullable = false, length = 50)
    private String airportName;

    @Column(name = "iata_code", nullable = false, length = 3)
    private String iataCode;

    @Column(name = "icao_code", nullable = false, length = 4)
    private String icaoCode;

    @Column(name = "city", nullable = false, length = 25)
    private String city;

    @Column(name = "country", nullable = false, length = 25)
    private String country;

    @Column(name = "airport_type", nullable = false, length = 25)
    private String airportType;
}