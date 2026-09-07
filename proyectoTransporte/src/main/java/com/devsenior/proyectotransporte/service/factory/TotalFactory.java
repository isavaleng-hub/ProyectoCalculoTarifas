package com.devsenior.proyectotransporte.service.factory;


import org.springframework.stereotype.Component;

import com.devsenior.proyectotransporte.dto.TripRequest;
import com.devsenior.proyectotransporte.model.FareType;
import com.devsenior.proyectotransporte.service.impl.EconomyFareStrategy;
import com.devsenior.proyectotransporte.service.impl.PremiumFareStrategy;
import com.devsenior.proyectotransporte.service.impl.SurgeFareStrategy;

@Component
public class TotalFactory {

    private final EconomyFareStrategy economyFareStrategy;
    private final PremiumFareStrategy premiumFareStrategy;
    private final SurgeFareStrategy surgeFareStrategy;

    public TotalFactory(EconomyFareStrategy economyFareStrategy, PremiumFareStrategy premiumFareStrategy, SurgeFareStrategy surgeFareStrategy) {
        this.economyFareStrategy = economyFareStrategy;
        this.premiumFareStrategy = premiumFareStrategy;
        this.surgeFareStrategy = surgeFareStrategy;
    }

    public double calculateTotal(TripRequest tripRequest) {
        double distance = tripRequest.getDistance();
        double duration = tripRequest.getDuration();
        FareType fareType = tripRequest.getFareType();

        switch (fareType) {
            case ECONOMY:
                return economyFareStrategy.calculateFare(distance, duration);
            case PREMIUM:
                return premiumFareStrategy.calculateFare(distance, duration);
            case SURGE:
                return surgeFareStrategy.calculateFare(distance, duration);
            default:
                throw new IllegalArgumentException("Tipo de tarifa no válido: " + fareType);
        }
    }
}