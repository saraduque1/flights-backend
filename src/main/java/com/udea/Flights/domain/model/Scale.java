package com.udea.Flights.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "scales")
public class Scale {
    @Id
    @Column(name = "id_scales", nullable = false)
    private Integer idScale;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_airport", nullable = false)
    private Airport idAirport;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_flight", nullable = false)
    private Flight idFlight;

    @Column(name = "scale_order", nullable = false)
    private Integer scaleOrder;

    @Column(name = "check_in", nullable = false)
    private LocalDateTime  checkIn;

    @Column(name = "check_out", nullable = false)
    private LocalDateTime checkOut;
}