package com.HippyAir.hippyair_backend.Controller;

import com.HippyAir.hippyair_backend.Model.Book;
import com.HippyAir.hippyair_backend.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Book> createBooking(@RequestParam String clientPassport,
                                              @RequestParam String flightNumber,
                                              @RequestParam String typeOfSeat) {
        return ResponseEntity.ok(bookingService.createBooking(clientPassport, flightNumber, typeOfSeat));
    }

    @GetMapping
    public List<Book> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
