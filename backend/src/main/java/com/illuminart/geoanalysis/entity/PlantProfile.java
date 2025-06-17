package com.illuminart.geoanalysis.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "plant_profiles")
public class PlantProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plantType;

    private Double optimalPh;
    private Double optimalN;
    private Double optimalP;
    private Double optimalK;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
