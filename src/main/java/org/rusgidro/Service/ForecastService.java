package org.rusgidro.Service;

import lombok.RequiredArgsConstructor;
import org.rusgidro.dto.ForecastResponseDTO;
import org.rusgidro.entity.City;
import org.rusgidro.entity.Forecast;
import org.rusgidro.entity.Sensor;
import org.rusgidro.entity.SensorType;
import org.rusgidro.repos.ForecastRepo;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ForecastService {
    private final ForecastRepo forecastRepo;
    private final CityService cityService;
    private final SensorTypeService sensorTypeService;
    private final SensorService sensorService;

    public List<ForecastResponseDTO> getForecastsByTypeCity(String city, String type) throws ParseException {
        try {
            City findedCity = cityService.getCityByName(city);
            SensorType sensorType = sensorTypeService.getSensorTypeByName(type);
            Sensor sensor = sensorService.getSensorByTypeAndCity(findedCity, sensorType);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<Forecast> forecastList = forecastRepo.findAllBySensor(sensor);
            List<ForecastResponseDTO> forecastResponseDTOList = new ArrayList<>();
            for (Forecast forecast1 : forecastList) {
                ForecastResponseDTO forecastResponseDTO = new ForecastResponseDTO();
                forecastResponseDTO.setCity(forecast1.getSensor().getCity().getCityName());
                forecastResponseDTO.setDate(sdf.format(forecast1.getForecastDate()));
                forecastResponseDTO.setValue(forecast1.getForecastValue());
                forecastResponseDTO.setIndexName(forecast1.getIndexType().getIndexName());
                forecastResponseDTOList.add(forecastResponseDTO);
            }
            return forecastResponseDTOList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
