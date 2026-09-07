package com.devsenior.proyectotransporte.service.impl;
;

import org.springframework.stereotype.Component;

import com.devsenior.proyectotransporte.service.FareStrategy;

@Component
public class EconomyFareStrategy implements FareStrategy {

    private static final double COST_PER_KM = 1.0;
    private static final double COST_PER_MINUTE = 0.5;

    @Override
    public double calculateFare(double distance, double duration) {
        return distance * COST_PER_KM + duration * COST_PER_MINUTE;
    }
}