package org.rusgidro.Service;

import lombok.RequiredArgsConstructor;
import org.rusgidro.entity.SensorType;
import org.rusgidro.repos.SensorTypeRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorTypeService {
    private final SensorTypeRepo sensorTypeRepo;

    public SensorType getSensorTypeByName(String typeName){
       return sensorTypeRepo.findBySensorTypeName(typeName);
    }
}
