package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.Model.Book;
import com.HippyAir.hippyair_backend.Model.Client;
import com.HippyAir.hippyair_backend.Model.Flight;
import com.HippyAir.hippyair_backend.Model.MilesReward;
import com.HippyAir.hippyair_backend.Repository.BookRepository;
import com.HippyAir.hippyair_backend.Repository.MilesRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MilesRewardRepository milesRewardRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private FlightService flightService;

    // Create booking
    public Book createBooking(String clientPassport, String flightNumber, String typeOfSeat) {
        Client client = clientService.getClientById(clientPassport);
        Flight flight = flightService.getFlightByNumber(flightNumber);

        if (flight.getNumberOfSeat() <= 0) {
            throw new RuntimeException("No seats available");
        }

        flight.setNumberOfSeat(flight.getNumberOfSeat() - 1);

        Book booking = new Book();
        booking.setClient(client);
        booking.setFlight(flight);
        booking.setTypeOfSeat(typeOfSeat);

        Book savedBooking = bookRepository.save(booking);

        MilesReward reward = new MilesReward();
        reward.setClient(client);
        reward.setFlight(flight);
        reward.setDate(LocalDate.now());
        milesRewardRepository.save(reward);

        return savedBooking;
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

