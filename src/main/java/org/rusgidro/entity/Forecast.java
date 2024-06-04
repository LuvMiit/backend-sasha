package org.rusgidro.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "airindex_forecast")
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forecast")
    private long forecastID;

    @Column(name ="forecast_value")
    private double forecastValue;

    @Column(name = "date_forecast")
    private Date forecastDate;

    @Column(name = "danger_class")
    private int dangerClass;

    @ManyToOne
    @JoinColumn(name = "type_forecast_id", referencedColumnName = "id_type_index")
    private IndexType indexType;

    @ManyToOne
    @JoinColumn(name = "sensor_forecast_id", referencedColumnName = "id_sensor")
    private Sensor sensor;
}
