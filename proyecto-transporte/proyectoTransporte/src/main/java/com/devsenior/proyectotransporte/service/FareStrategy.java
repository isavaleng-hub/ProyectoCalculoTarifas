package com.devsenior.proyectotransporte.service;

public interface FareStrategy {
    double calculateFare(double distance, double duration);
}