package com.example.flight_reservation.Controller;

import com.example.flight_reservation.Model.Booking;
import com.example.flight_reservation.Model.Flight;
import com.example.flight_reservation.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookings/{id}")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/bookings/{id}")
    public Booking getBooking(@PathVariable int id) {
        return bookingService.getBooking(id);
    }

    @PutMapping("/bookings/{id}")
    public Booking updateFlight(@RequestBody Booking booking){
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        bookingService.deleteBookingById(id);
        return ResponseEntity.ok("Booking deleted successfully.");
    }


}

