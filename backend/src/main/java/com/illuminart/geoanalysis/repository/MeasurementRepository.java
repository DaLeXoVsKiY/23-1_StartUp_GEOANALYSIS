package com.illuminart.geoanalysis.repository;

import com.illuminart.geoanalysis.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findByDeviceId(Long deviceId);
}
