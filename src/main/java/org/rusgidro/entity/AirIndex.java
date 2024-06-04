package org.rusgidro.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "AIRindex")
@NoArgsConstructor
@Data
public class AirIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_index")
    private long indexID;

    @Column(name = "index_value")
    private double indexValue;

    @Column(name = "date_read")
    private Date readDate;

    @ManyToOne
    @JoinColumn(name="type_index_id", referencedColumnName = "id_type_index")
    private IndexType typeIndex;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id_sensor")
    private Sensor sensor;

    @Column(name = "danger_class")
    private long dangerClass;

}
