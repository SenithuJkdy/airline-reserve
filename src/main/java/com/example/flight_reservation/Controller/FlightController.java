package com.example.flight_reservation.Controller;

import com.example.flight_reservation.Model.Flight;
import com.example.flight_reservation.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/flights")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.addFlight(flight));
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @PutMapping("/flights/{id}")
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.updateFlight(flight);
    }

    @DeleteMapping("/flights/{id}")
    public String deleteFlight(@PathVariable int id){
        flightService.deleteFlights(id);
        return "flight deleted";
    }

}

