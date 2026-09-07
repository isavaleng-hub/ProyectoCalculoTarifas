package com.devsenior.proyectotransporte.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.proyectotransporte.dto.TripRequest;
import com.devsenior.proyectotransporte.model.Trip;
import com.devsenior.proyectotransporte.service.ITripService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController implements ITripController {

    private final ITripService service;

    @Override
    @PostMapping
    public ResponseEntity<Trip> createTrip(@Valid @RequestBody TripRequest request) {
        Trip trip = service.createTrip(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(trip);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Trip>> listTrips() {
        List<Trip> trips = service.listTrips();
        return ResponseEntity.ok(trips);
    }
}