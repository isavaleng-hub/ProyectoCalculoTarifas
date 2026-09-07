package com.devsenior.proyectotransporte.service;

import java.util.List;

import com.devsenior.proyectotransporte.dto.TripRequest;
import com.devsenior.proyectotransporte.model.Trip;

public interface ITripService {
    public Trip createTrip(TripRequest tripRequest);
    public List<Trip> listTrips();
}