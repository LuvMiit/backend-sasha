package org.rusgidro.dto;

import lombok.Data;

@Data
public class UpdateValueDTO {
    private String city;
    private String date;
    private String typeIndex;
    private Double newValue;
}
