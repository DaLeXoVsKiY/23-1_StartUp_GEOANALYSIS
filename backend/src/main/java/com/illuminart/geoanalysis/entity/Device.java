package com.illuminart.geoanalysis.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceSerial;

    private String location;

    private Integer batteryLevel;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<Measurement> measurements;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<Action> actions;

}
