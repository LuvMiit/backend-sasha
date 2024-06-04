package org.rusgidro.repos;

import org.rusgidro.entity.Forecast;
import org.rusgidro.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ForecastRepo extends JpaRepository<Forecast, Long> {
    List<Forecast> findAllBySensor(Sensor sensor);
}
