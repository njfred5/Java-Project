package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.model.Book;
import com.HippyAir.hippyair_backend.model.Client;
import com.HippyAir.hippyair_backend.model.Flight;
import com.HippyAir.hippyair_backend.model.MilesReward;
import com.HippyAir.hippyair_backend.repository.BookRepository;
import com.HippyAir.hippyair_backend.repository.FlightRepository;
import com.HippyAir.hippyair_backend.repository.MilesRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private MilesRewardRepository milesRewardRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private FlightService flightService;

    // Create booking and add reward
    public Book createBooking(String clientPassport, String flightNumber, String typeOfSeat) {
        Client client = clientService.getClientByPassport(clientPassport);
        Flight flight = flightService.getFlightByNumber(flightNumber);

        if (flight.getNumberOfSeat() <= 0) {
            throw new RuntimeException("No seats available");
        }

        // decrement seat and persist flight
        flight.setNumberOfSeat(flight.getNumberOfSeat() - 1);
        flightRepository.save(flight);

        // create booking
        Book booking = new Book();
        booking.setClient(client);
        booking.setFlight(flight);
        booking.setTypeOfSeat(typeOfSeat);
        booking.setBookingDate(LocalDateTime.now());

        Book savedBooking = bookRepository.save(booking);

        // add miles reward entry
        MilesReward reward = new MilesReward();
        reward.setClient(client);
        reward.setFlight(flight);
        reward.setDate(LocalDate.now());
        milesRewardRepository.save(reward);

        return savedBooking;
    }

    // Get booking by ID
    public Book getBookingById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    // Update booking (only seat type for simplicity)
    public Book updateBooking(Long id, String typeOfSeat) {
        Book booking = getBookingById(id);
        booking.setTypeOfSeat(typeOfSeat);
        return bookRepository.save(booking);
    }

    // Get all bookings
    public List<Book> getAllBookings() {
        return bookRepository.findAll();
    }

    // Delete booking
    public void deleteBooking(Long id) {
        bookRepository.deleteById(id);
    }
}
