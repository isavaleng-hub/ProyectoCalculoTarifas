package com.devsenior.proyectotransporte.service;


import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.proyectotransporte.dto.TripRequest;
import com.devsenior.proyectotransporte.model.FareType;
import com.devsenior.proyectotransporte.model.Trip;
import com.devsenior.proyectotransporte.repository.ITripRepository;
import com.devsenior.proyectotransporte.service.factory.TotalFactory;

@Service
public class TripService implements ITripService {

    private final ITripRepository tripRepository;
    private final TotalFactory totalFactory;

    public TripService(ITripRepository tripRepository, TotalFactory totalFactory) {
        this.tripRepository = tripRepository;
        this.totalFactory = totalFactory;
    }

    @Override
    // El service recibe del controller el TripRequest (DTO con los datos necesarios para calcular la tarifa).
    // Determina el tipo de tarifa, delega el cálculo en la estrategia correspondiente (vía TotalFactory)
    // y guarda el viaje en el repositorio.
    public Trip createTrip(TripRequest tripRequest) {
        FareType fareType = tripRequest.getFareType();
        double total = totalFactory.calculateTotal(tripRequest);

        Trip trip = new Trip();
        trip.setDistance(tripRequest.getDistance());
        trip.setDuration(tripRequest.getDuration());
        trip.setFareType(fareType);
        trip.setTotalFare(total);
        trip.setUserEmail(tripRequest.getUserEmail());
        return tripRepository.save(trip);
    }

    @Override
    // El service devuelve una lista de Trip (modelo), no DTOs; el controller se encarga de esa conversión si hiciera falta.
    public List<Trip> listTrips() {
        return tripRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Trip::getTotalFare).reversed()) // Ordenado por tarifa total, de mayor a menor
                .toList();
    }
}