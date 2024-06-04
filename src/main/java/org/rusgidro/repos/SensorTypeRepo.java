package org.rusgidro.repos;

import org.rusgidro.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorTypeRepo extends JpaRepository<SensorType, Long> {
    SensorType findBySensorTypeName(String typeName);
}
