package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "miles_reward")
public class MilesReward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_flight")
    private Flight flight;

    private LocalDate date;

    // getters and setters
}