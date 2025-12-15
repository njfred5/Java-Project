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
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDateTime getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(LocalDateTime departureHour) {
        this.departureHour = departureHour;
    }

    public LocalDateTime getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(LocalDateTime arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Integer getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(Integer numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public BigDecimal getFirstClassSeatPrice() {
        return firstClassSeatPrice;
    }

    public void setFirstClassSeatPrice(BigDecimal firstClassSeatPrice) {
        this.firstClassSeatPrice = firstClassSeatPrice;
    }

    public BigDecimal getPremiumSeatPrice() {
        return premiumSeatPrice;
    }

    public void setPremiumSeatPrice(BigDecimal premiumSeatPrice) {
        this.premiumSeatPrice = premiumSeatPrice;
    }

    public BigDecimal getBusinessClassPrice() {
        return businessClassPrice;
    }

    public void setBusinessClassPrice(BigDecimal businessClassPrice) {
        this.businessClassPrice = businessClassPrice;
    }

    public BigDecimal getEconomyClassPrice() {
        return economyClassPrice;
    }

    public void setEconomyClassPrice(BigDecimal economyClassPrice) {
        this.economyClassPrice = economyClassPrice;
    }

    public List<Book> getBookings() {
        return bookings;
    }

    public void setBookings(List<Book> bookings) {
        this.bookings = bookings;
    }

    public List<MilesReward> getRewards() {
        return rewards;
    }

    public void setRewards(List<MilesReward> rewards) {
        this.rewards = rewards;
    }
}
