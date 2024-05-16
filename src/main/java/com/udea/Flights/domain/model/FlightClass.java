package com.udea.Flights.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "flight_classes")
public class FlightClass {
    @Id
    @Column(name = "id_flight_class", nullable = false)
    private Integer idFlightClass;

    @Column(name = "name_type_class", nullable = false, length = 50)
    private String nameTypeClass;

}