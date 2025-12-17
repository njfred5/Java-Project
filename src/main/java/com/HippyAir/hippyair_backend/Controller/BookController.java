package com.HippyAir.hippyair_backend.Controller;

import com.HippyAir.hippyair_backend.model.Book;
import com.HippyAir.hippyair_backend.Service.BookingService;
import com.HippyAir.hippyair_backend.DTO.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookController {

    @Autowired
    private BookingService bookingService;

    // Create booking
    @PostMapping
    public ResponseEntity<BookDTO> createBooking(@RequestParam String clientPassport,
                                                 @RequestParam String flightNumber,
                                                 @RequestParam String typeOfSeat) {
        Book book = bookingService.createBooking(clientPassport, flightNumber, typeOfSeat);
        return ResponseEntity.ok(toDTO(book));
    }

    // Get all bookings
    @GetMapping
    public List<BookDTO> getAllBookings() {
        return bookingService.getAllBookings().stream()
                .map(this::toDTO)
                .toList();
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBooking(@PathVariable Long id) {
        Book book = bookingService.getBookingById(id);
        return ResponseEntity.ok(toDTO(book));
    }

    // Update booking (seat type only for simplicity)
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBooking(@PathVariable Long id,
                                                 @RequestParam String typeOfSeat) {
        Book book = bookingService.updateBooking(id, typeOfSeat);
        return ResponseEntity.ok(toDTO(book));
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    // Helper method to convert entity -> DTO
    private BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setIdReservation(book.getIdReservation());
        dto.setTypeOfSeat(book.getTypeOfSeat());
        dto.setClientPassport(book.getClient() != null ? book.getClient().getNumPassport() : null);
        dto.setFlightNumber(book.getFlight() != null ? book.getFlight().getFlightNumber() : null);
        dto.setBookingDate(book.getBookingDate());
        return dto;
    }
}
