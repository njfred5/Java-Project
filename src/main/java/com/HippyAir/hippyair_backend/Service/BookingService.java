package com.HippyAir.hippyair_backend.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private MilesRewardRepository milesRewardRepository;
    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    public Booking createBooking(BookingRequestDTO dto) {
        // 1. Find or create Client
        Client client = clientRepository.findByPassportNumber(dto.getPassportNumber())
            .orElseGet(() -> createNewClient(dto));

        // 2. Find Flight
        Flight flight = flightRepository.findByFlightNumber(dto.getFlightNumber())
            .orElseThrow(() -> new RuntimeException("Flight not found"));

        // 3. Check seat availability
        if (!flight.hasAvailableSeat(dto.getTypeOfSeat())) {
            throw new RuntimeException("No available seat for type: " + dto.getTypeOfSeat());
        }

        // 4. Create Booking
        Booking booking = new Booking();
        booking.setClient(client);
        booking.setFlight(flight);
        booking.setTypeOfSeat(dto.getTypeOfSeat());
        bookingRepository.save(booking);

        // 5. Update MilesReward
        MilesReward reward = new MilesReward(client.getId(), flight.getId(), LocalDate.now());
        milesRewardRepository.save(reward);

        // 6. Check if client qualifies for discount
        long flightsThisYear = milesRewardRepository.countByClientIdAndYear(client.getId(), Year.now().getValue());
        if (flightsThisYear >= 3) {
            DiscountCode code = new DiscountCode(client.getId(), generateRandomCode());
            discountCodeRepository.save(code);
        }

        return booking;
    }

    private Client createNewClient(BookingRequestDTO dto) {
        User user = new User(dto.getFirstname(), dto.getLastname(), dto.getEmail(), dto.getPhone(), dto.getBirthdate());
        Client client = new Client(dto.getPassportNumber(), user);
        return clientRepository.save(client);
    }

    // Other CRUD methods: getAllBookings, getBookingById, updateBooking, deleteBooking
}
