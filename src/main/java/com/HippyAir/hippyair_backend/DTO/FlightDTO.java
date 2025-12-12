package com.HippyAir.hippyair_backend.DTO;
import java.time.LocalDateTime;

public class FlightDTO {

   private Long planeId;
   private Long departureAirportId;
   private Long arrivalAirportId;

   private LocalDateTime departureTime;
   private LocalDateTime arrivalTime;
   private Double price;

}
