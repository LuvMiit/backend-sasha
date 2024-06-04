package org.rusgidro.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AllAttributesIndexDTO {
    private String indexName;
    private double value;
    private String date;
    private String city;
    private double standart;
    private long dangerClass;
    private double isa;
    private double pi;
}
