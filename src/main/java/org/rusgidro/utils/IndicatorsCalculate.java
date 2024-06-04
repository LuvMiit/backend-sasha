package org.rusgidro.utils;

import lombok.Data;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Data
public class IndicatorsCalculate {

    private static final long EL1 = 1;
    private static final long EL2 = 2;
    private static final long EL3 = 3;
    private static final long EL4 = 4;
    private static final long EL5 = 5;
    private static Map<Long, Double> dangerValue = Map.ofEntries(

            Map.entry(EL1, 1.7),
            Map.entry(EL2, 1.3),
            Map.entry(EL3, 1.0),
            Map.entry(EL4, 0.9),
            Map.entry(EL5, 0.75)
    );
    public static double computeISA(double index, long dangerClass, double pdk){
        return (index/pdk)*dangerValue.get(dangerClass);
    }
    public static double computePI(double index, double pdk){
        return (index/pdk)*1;
    }
}
