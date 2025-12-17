package com.HippyAir.hippyair_backend.DTO;

import java.time.LocalDateTime;

public class BookDTO {
    private Long idReservation;
    private String typeOfSeat;
    private String clientPassport;
    private String flightNumber;
    private LocalDateTime bookingDate;

    // getters and setters
    public Long getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public String getTypeOfSeat() {
        return typeOfSeat;
    }
    public void setTypeOfSeat(String typeOfSeat) {
        this.typeOfSeat = typeOfSeat;
    }

    public String getClientPassport() {
        return clientPassport;
    }
    public void setClientPassport(String clientPassport) {
        this.clientPassport = clientPassport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}
