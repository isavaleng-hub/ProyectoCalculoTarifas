package com.devsenior.proyectotransporte.repository;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devsenior.proyectotransporte.model.Trip;

@Repository
public class TripRepository implements ITripRepository {

    private final List<Trip> trips = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    // agregamos un id manualmente y guardamos el viaje en la lista
    public Trip save(Trip trip) {
        trip.setId(idCounter++);
        trips.add(trip);
        return trip;
    }

    @Override
    public List<Trip> findAll() {
        return Collections.unmodifiableList(trips);
    }
}