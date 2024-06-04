package org.rusgidro.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "sensor_type")
@NoArgsConstructor
public class SensorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sensor_type")
    private long typeID;

    @Column(name = "name_sensor_type")
    private String sensorTypeName;
}
