package com.illuminart.geoanalysis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User {
    // геттеры/сеттеры
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(unique = true)
    private String email;

    @Setter
    private String password;

    private String fullName;

    public void setFullName(Object fullName) {
        this.fullName = fullName.toString();
    }

}

