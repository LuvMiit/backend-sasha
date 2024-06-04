package org.rusgidro.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "sensor")
@NoArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sensor")
    private long sensorID;

    @ManyToOne
    @JoinColumn(name = "type_sensor_id", referencedColumnName = "id_sensor_type")
    private SensorType sensorType;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id_city")
    private City city;
}
