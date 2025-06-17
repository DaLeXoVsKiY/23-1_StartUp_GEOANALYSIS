package com.illuminart.geoanalysis.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
public class Measurement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    private Double pH;
    private Double moisture;
    private Double temperature;
    private Double n;
    private Double p;
    private Double k;
    private Double mg;
    private Double ca;
    private Double ec;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}