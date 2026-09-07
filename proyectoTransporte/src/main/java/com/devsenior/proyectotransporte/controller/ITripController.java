package com.devsenior.proyectotransporte.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.devsenior.proyectotransporte.dto.TripRequest;
import com.devsenior.proyectotransporte.model.Trip;

public interface ITripController {
    ResponseEntity<Trip> createTrip(TripRequest request);
    ResponseEntity<List<Trip>> listTrips();
}