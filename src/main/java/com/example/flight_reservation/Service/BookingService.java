package com.example.flight_reservation.Service;

import com.example.flight_reservation.Model.Booking;
import com.example.flight_reservation.Model.Flight;
import com.example.flight_reservation.Model.User;
import com.example.flight_reservation.Repository.BookingRepository;
import com.example.flight_reservation.Repository.FlightRepository;
import com.example.flight_reservation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FlightRepository flightRepository;

    public Booking getBooking(int id){
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        // Fetch user and flight by their IDs
        User user = userRepository.findById(booking.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Flight flight = flightRepository.findById(booking.getFlight().getId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        // Set fetched user and flight to booking
        booking.setUser(user);
        booking.setFlight(flight);

        return bookingRepository.save(booking);
    }

    public String deleteBookingById(int id){
        userRepository.deleteById(id);
        return id+" booking removed";
    }
}

