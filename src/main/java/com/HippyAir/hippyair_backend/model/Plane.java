package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "plane")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlane;

    private String brand;
    private String model;
    private Integer manufacturingYear;

    @OneToMany(mappedBy = "plane")
    private List<Flight> flights;

    // getters and setters
}