package com.HippyAir.hippyair_backend.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class FlightDTO {
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureHour;
    private LocalDateTime arrivalHour;

    // Connected entities by ID
    private Long departureAirportId;
    private Long arrivalAirportId;
    private Long planeId;

    // Prices and seats
    private Integer numberOfSeat;
    private BigDecimal firstClassSeatPrice;
    private BigDecimal premiumSeatPrice;
    private BigDecimal businessClassPrice;
    private BigDecimal economyClassPrice;

    // Connected collections (only IDs to avoid recursion)
    private List<Long> bookingIds;
    private List<Long> rewardIds;

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

    public Long getDepartureAirportId() { return departureAirportId; }
    public void setDepartureAirportId(Long departureAirportId) { this.departureAirportId = departureAirportId; }

    public Long getArrivalAirportId() { return arrivalAirportId; }
    public void setArrivalAirportId(Long arrivalAirportId) { this.arrivalAirportId = arrivalAirportId; }

    public Long getPlaneId() { return planeId; }
    public void setPlaneId(Long planeId) { this.planeId = planeId; }

    public Integer getNumberOfSeat() { return numberOfSeat; }
    public void setNumberOfSeat(Integer numberOfSeat) { this.numberOfSeat = numberOfSeat; }

    public BigDecimal getFirstClassSeatPrice() { return firstClassSeatPrice; }
    public void setFirstClassSeatPrice(BigDecimal firstClassSeatPrice) { this.firstClassSeatPrice = firstClassSeatPrice; }

    public BigDecimal getPremiumSeatPrice() { return premiumSeatPrice; }
    public void setPremiumSeatPrice(BigDecimal premiumSeatPrice) { this.premiumSeatPrice = premiumSeatPrice; }

    public BigDecimal getBusinessClassPrice() { return businessClassPrice; }
    public void setBusinessClassPrice(BigDecimal businessClassPrice) { this.businessClassPrice = businessClassPrice; }

    public BigDecimal getEconomyClassPrice() { return economyClassPrice; }
    public void setEconomyClassPrice(BigDecimal economyClassPrice) { this.economyClassPrice = economyClassPrice; }

    public List<Long> getBookingIds() { return bookingIds; }
    public void setBookingIds(List<Long> bookingIds) { this.bookingIds = bookingIds; }

    public List<Long> getRewardIds() { return rewardIds; }
    public void setRewardIds(List<Long> rewardIds) { this.rewardIds = rewardIds; }
}
