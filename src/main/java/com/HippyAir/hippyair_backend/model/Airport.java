package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAirport;

    private String nameAirport;
    private String countryAirport;
    private String cityAirport;

    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departingFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivingFlights;

    // getters and setters
    public Long getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Long idAirport) {
        this.idAirport = idAirport;
    }

    public String getNameAirport() {
        return nameAirport;
    }

    public void setNameAirport(String nameAirport) {
        this.nameAirport = nameAirport;
    }

    public String getCountryAirport() {
        return countryAirport;
    }

    public void setCountryAirport(String countryAirport) {
        this.countryAirport = countryAirport;
    }

    public String getCityAirport() {
        return cityAirport;
    }

    public void setCityAirport(String cityAirport) {
        this.cityAirport = cityAirport;
    }
}
