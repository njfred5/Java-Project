package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    private String flightNumber;

    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureHour;
    private LocalDateTime arrivalHour;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "id_plane")
    private Plane plane;

    private Integer numberOfSeat;
    private BigDecimal firstClassSeatPrice;
    private BigDecimal premiumSeatPrice;
    private BigDecimal businessClassPrice;
    private BigDecimal economyClassPrice;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Book> bookings;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<MilesReward> rewards;

    // getters and setters
}
