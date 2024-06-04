package org.rusgidro.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Data
@Table(name = "type_index")
@NoArgsConstructor
public class IndexType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_index")
    private long typeID;

    @Column(name = "name_index")
    private String indexName;

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "standart_id", referencedColumnName = "id_standart")
    private Standart standart;
}
