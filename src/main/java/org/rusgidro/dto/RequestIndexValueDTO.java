package org.rusgidro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestIndexValueDTO {
    private String city;
    private String indexType;
    private String date;
}
