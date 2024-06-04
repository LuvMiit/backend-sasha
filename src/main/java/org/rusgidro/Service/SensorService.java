package org.rusgidro.Service;

import lombok.RequiredArgsConstructor;
import org.rusgidro.entity.City;
import org.rusgidro.entity.Sensor;
import org.rusgidro.entity.SensorType;
import org.rusgidro.repos.SensorRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepo sensorRepo;

    public Sensor getSensorByTypeAndCity(City city, SensorType type){
        return sensorRepo.findBySensorTypeAndCity(type, city);
    }
}
