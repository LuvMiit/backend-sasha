package org.rusgidro.controllers;

import lombok.RequiredArgsConstructor;
import org.rusgidro.Service.ForecastService;
import org.rusgidro.dto.ForecastResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/forecast")
public class ForecastController {

    private final ForecastService forecastService;

    @GetMapping("/all/{city}/{type}")
    public List<ForecastResponseDTO> getForecasts(
            @PathVariable("city") String city,
            @PathVariable("type") String type
    ) throws ParseException {
        return  forecastService.getForecastsByTypeCity(city, type);
    }
}
