package org.rusgidro.dto;

import lombok.Data;

@Data
public class ForecastResponseDTO {
    private String indexName;
    private double value;
    private String date;
    private String city;
}
