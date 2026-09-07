package com.devsenior.proyectotransporte.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Trip {
    private Long id;
    private double distance;
    private double duration;
    private FareType fareType;
    private String userEmail;
    private double totalFare;
}
