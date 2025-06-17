package com.illuminart.geoanalysis.entity;

import com.illuminart.geoanalysis.model.enums.ActionStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "actions")
public class Action {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    private String nutrientType;

    private Double amountMl;

    @Enumerated(EnumType.STRING)
    private ActionStatus status;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}
