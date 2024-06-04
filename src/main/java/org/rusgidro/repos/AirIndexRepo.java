package org.rusgidro.repos;

import org.rusgidro.entity.AirIndex;
import org.rusgidro.entity.IndexType;
import org.rusgidro.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AirIndexRepo extends JpaRepository<AirIndex, Long> {
    AirIndex findByTypeIndexAndSensorAndReadDate(IndexType typeIndex, Sensor sensor, Date readDate);
}
