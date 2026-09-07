package com.devsenior.proyectotransporte.repository;

import java.util.List;

import com.devsenior.proyectotransporte.model.Trip;

public interface ITripRepository {
    Trip save(Trip trip);
    List<Trip> findAll();
}