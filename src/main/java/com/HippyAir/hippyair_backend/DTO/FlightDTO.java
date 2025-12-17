package com.HippyAir.hippyair_backend.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightDTO {
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureHour;
    private LocalDateTime arrivalHour;
    private Integer numberOfSeat;
    private BigDecimal economyClassPrice;

    // getters and setters
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getDepartureCity() { return departureCity; }
    public void setDepartureCity(String departureCity) { this.departureCity = departureCity; }

    public String getArrivalCity() { return arrivalCity; }
    public void setArrivalCity(String arrivalCity) { this.arrivalCity = arrivalCity; }

    public LocalDateTime getDepartureHour() { return departureHour; }
    public void setDepartureHour(LocalDateTime departureHour) { this.departureHour = departureHour; }

    public LocalDateTime getArrivalHour() { return arrivalHour; }
    public void setArrivalHour(LocalDateTime arrivalHour) { this.arrivalHour = arrivalHour; }

    public Integer getNumberOfSeat() { return numberOfSeat; }
    public void setNumberOfSeat(Integer numberOfSeat) { this.numberOfSeat = numberOfSeat; }

    public BigDecimal getEconomyClassPrice() { return economyClassPrice; }
    public void setEconomyClassPrice(BigDecimal economyClassPrice) { this.economyClassPrice = economyClassPrice; }
}
