package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private String numEmp;

    private String profession;
    private String title;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters and setters
}
