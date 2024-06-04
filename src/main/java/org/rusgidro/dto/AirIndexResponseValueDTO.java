package org.rusgidro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirIndexResponseValueDTO {
    private String indexValue;
    private String description;
    private String recommend;
}
