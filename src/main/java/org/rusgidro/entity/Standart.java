package org.rusgidro.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="standart")
@NoArgsConstructor
public class Standart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_standart")
    private long standartID;

    @Column(name = "standart_value_max")
    private double standartValueMAX;

    @Column(name = "standart_value_day")
    private double standartValueDAY;
}
