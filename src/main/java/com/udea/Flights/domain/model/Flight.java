package com.udea.Flights.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight", nullable = false)
    private Integer idFlight;

    @Column(name = "flight_number", nullable = false, length = 6)
    private String flightNumber;

    @Column(name = "departure_date", nullable = false)
    private LocalDateTime  departureDate;

    @Column(name = "arrival_date", nullable = false)
    private LocalDateTime arrivalDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_airline", nullable = false)
    private Airline idAirline;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_airport_origin", nullable = false)
    private Airport idAirportOrigin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_airport_destination", nullable = false)
    private Airport idAirportDestination;

}