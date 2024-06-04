package org.rusgidro.repos;

import org.rusgidro.entity.City;
import org.rusgidro.entity.Sensor;
import org.rusgidro.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepo extends JpaRepository<Sensor, Long> {
    Sensor findBySensorTypeAndCity(SensorType sensorType, City city);
}
