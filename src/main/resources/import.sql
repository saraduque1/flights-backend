create table airlines
(
    id_airline   int auto_increment
        primary key,
    airline_name varchar(50) not null,
    country      varchar(50) not null
);

create table airports
(
    id_airport   int auto_increment
        primary key,
    airport_name varchar(50) not null,
    iata_code    varchar(3)  not null,
    icao_code    varchar(4)  not null,
    city         varchar(25) not null,
    country      varchar(25) not null,
    airport_type varchar(25) not null
);

create table flights
(
    id_flight              int auto_increment
        primary key,
    id_airline             int        not null,
    id_airport_origin      int        not null,
    id_airport_destination int        not null,
    flight_number          varchar(6) not null,
    departure_date         date       not null,
    departure_time         time       not null,
    arrival_date           date       not null,
    arrival_time           time       not null,
    constraint flights_ibfk_1
        foreign key (id_airline) references airlines (id_airline),
    constraint flights_ibfk_2
        foreign key (id_airport_origin) references airports (id_airport),
    constraint flights_ibfk_3
        foreign key (id_airport_destination) references airports (id_airport)
);

create index id_airline
    on flights (id_airline);

create index id_airport_destination
    on flights (id_airport_destination);

create index id_airport_origin
    on flights (id_airport_origin);

create table flight_classes
(
    id_flight_class int auto_increment
        primary key,
    name_type_class varchar(50) not null
);

create table fares
(
    id_fare         int auto_increment
        primary key,
    id_flight       int            not null,
    id_flight_class int            not null,
    price           decimal(10, 2) not null,
    constraint fares_ibfk_1
        foreign key (id_flight) references flights (id_flight),
    constraint fares_ibfk_2
        foreign key (id_flight_class) references flight_classes (id_flight_class)
);

create index id_flight
    on fares (id_flight);

create index id_flight_class
    on fares (id_flight_class);

create table scales
(
    id_scales   int      not null
        primary key,
    id_airport  int      not null,
    id_flight   int      not null,
    scale_order int      not null,
    check_in    datetime not null,
    check_out   datetime not null,
    constraint scales_ibfk_1
        foreign key (id_airport) references airports (id_airport),
    constraint scales_ibfk_2
        foreign key (id_flight) references flights (id_flight)
);

create index id_airport
    on scales (id_airport);

create index id_flight
    on scales (id_flight);

INSERT INTO flights_management.airlines (id_airline, airline_name, country) VALUES (1, 'Emirates', 'Emiratos Árabes Unidos');
INSERT INTO flights_management.airlines (id_airline, airline_name, country) VALUES (2, 'Avianca', 'Colombia');
INSERT INTO flights_management.airlines (id_airline, airline_name, country) VALUES (3, 'American Airlines', 'Estados Unidos');
INSERT INTO flights_management.airlines (id_airline, airline_name, country) VALUES (4, 'LATAM Airlines', 'Chile');

INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (1, 'Aeropuerto Internacional El Dorado', 'BOG', 'SKBO', 'Bogotá', 'Colombia', 'Internacional');
INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (2, 'Aeropuerto Internacional José María Córdova', 'MDE', 'SKMD', 'Medellín', 'Colombia', 'Internacional');
INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (3, 'Aeropuerto Internacional Alfonso Bonilla Aragón', 'CLO', 'SKCL', 'Cali', 'Colombia', 'Internacional');
INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (4, 'Aeropuerto Internacional Ernesto Cortissoz', 'BAQ', 'SKBA', 'Cartagena', 'Colombia', 'Internacional');
INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (5, 'Aeropuerto Internacional Rafael Núñez', 'CTG', 'SKCT', 'Cartagena', 'Colombia', 'Internacional');
INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (6, 'Aeropuerto Internacional Simón Bolívar', 'BVU', 'SKBU', 'Barranquilla', 'Colombia', 'Internacional');
INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (7, 'Aeropuerto Internacional Gustavo Rojas Pinilla', 'ADZ', 'SKAD', 'Ibagué', 'Colombia', 'Internacional');
INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (8, 'Aeropuerto Internacional Palonegro', 'EOH', 'SKEO', 'Manizales', 'Colombia', 'Internacional');
INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (9, 'Aeropuerto Internacional Antonio Nariño', 'PSA', 'SKPS', 'Pasto', 'Colombia', 'Internacional');
INSERT INTO flights_management.airports (id_airport, airport_name, iata_code, icao_code, city, country, airport_type) VALUES (10, 'Aeropuerto Internacional Almirante Padilla', 'RCH', 'SKRC', 'Sincelejo', 'Colombia', 'Internacional');

INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (1, 1, 1, 2, 'EM101', '2024-06-01', '08:00:00', '2024-06-01', '10:00:00');
INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (2, 2, 2, 3, 'AV202', '2024-06-02', '09:00:00', '2024-06-02', '11:00:00');
INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (3, 3, 3, 4, 'AA303', '2024-06-03', '10:00:00', '2024-06-03', '12:00:00');
INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (4, 4, 4, 5, 'LA404', '2024-06-04', '11:00:00', '2024-06-04', '13:00:00');
INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (5, 1, 5, 6, 'EM505', '2024-06-05', '12:00:00', '2024-06-05', '14:00:00');
INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (6, 2, 6, 7, 'AV606', '2024-06-06', '13:00:00', '2024-06-06', '15:00:00');
INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (7, 3, 7, 8, 'AA707', '2024-06-07', '14:00:00', '2024-06-07', '16:00:00');
INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (8, 4, 8, 9, 'LA808', '2024-06-08', '15:00:00', '2024-06-08', '17:00:00');
INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (9, 1, 9, 10, 'EM909', '2024-06-09', '16:00:00', '2024-06-09', '18:00:00');
INSERT INTO flights_management.flights (id_flight, id_airline, id_airport_origin, id_airport_destination, flight_number, departure_date, departure_time, arrival_date, arrival_time) VALUES (10, 2, 10, 1, 'AV010', '2024-06-10', '17:00:00', '2024-06-10', '19:00:00');

INSERT INTO flights_management.flight_classes (id_flight_class, name_type_class) VALUES (1, 'Económica');
INSERT INTO flights_management.flight_classes (id_flight_class, name_type_class) VALUES (2, 'Premium economy');
INSERT INTO flights_management.flight_classes (id_flight_class, name_type_class) VALUES (3, 'Ejecutiva');
INSERT INTO flights_management.flight_classes (id_flight_class, name_type_class) VALUES (4, 'Primera Clase');

INSERT INTO flights_management.fares (id_fare, id_flight, id_flight_class, price) VALUES (7, 1, 1, 430000.00);
INSERT INTO flights_management.fares (id_fare, id_flight, id_flight_class, price) VALUES (8, 1, 2, 600000.00);
INSERT INTO flights_management.fares (id_fare, id_flight, id_flight_class, price) VALUES (9, 2, 3, 3000000.00);
INSERT INTO flights_management.fares (id_fare, id_flight, id_flight_class, price) VALUES (10, 2, 4, 4800000.00);
INSERT INTO flights_management.fares (id_fare, id_flight, id_flight_class, price) VALUES (11, 3, 1, 500000.00);
INSERT INTO flights_management.fares (id_fare, id_flight, id_flight_class, price) VALUES (12, 3, 4, 4000000.00);

