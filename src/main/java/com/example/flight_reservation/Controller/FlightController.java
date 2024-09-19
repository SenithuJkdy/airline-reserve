package com.example.flight_reservation.Controller;

import com.example.flight_reservation.Model.Flight;
import com.example.flight_reservation.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/addf")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.addFlight(flight));
    }

    @GetMapping("/getf")
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }
}

