package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @ManyToOne
    @JoinColumn(name = "id_flight")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    private String typeOfSeat;
    private LocalDateTime bookingDate;

    // getters and setters
}
