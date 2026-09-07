package com.devsenior.proyectotransporte.dto;
import com.devsenior.proyectotransporte.model.FareType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TripRequest {

    @NotNull
    @Positive
    private Double distance;

    @NotNull
    @Positive
    private Double duration;

    @NotNull
    private FareType fareType;

    @NotNull
    @Email
    private String userEmail;
}