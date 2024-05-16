package com.udea.Flights.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "airlines")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airline", nullable = false)
    private Integer idAirline;

    @Column(name = "airline_name", nullable = false, length = 50)
    private String airlineName;

    @Column(name = "country", nullable = false, length = 50)
    private String country;
}