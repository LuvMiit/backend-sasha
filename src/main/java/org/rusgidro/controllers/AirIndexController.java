package org.rusgidro.controllers;

import lombok.RequiredArgsConstructor;
import org.rusgidro.Service.AirIndexService;
import org.rusgidro.dto.AirIndexResponseValueDTO;
import org.rusgidro.dto.AllAttributesIndexDTO;
import org.rusgidro.dto.RequestIndexValueDTO;
import org.rusgidro.dto.UpdateValueDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/airIndex")
public class AirIndexController {
    private final AirIndexService airIndexService;

    @GetMapping("/{city}/{indexType}/{date}")
    public AirIndexResponseValueDTO getIndexValue(
            @PathVariable("city") String city,
            @PathVariable("indexType") String indexType,
            @PathVariable("date") String date
    ) throws ParseException {

         return airIndexService.getIndexValueAndDescription(new RequestIndexValueDTO(
                 city, indexType, date));
    }

    @GetMapping("/all-index")
    public List<AllAttributesIndexDTO> getAllIndexes() throws ParseException {
         return airIndexService.getAllIndexes();
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateValue(
            @RequestBody UpdateValueDTO updatedValue
    ) throws ParseException {

        if(airIndexService.updateValueByDateTypeCity(updatedValue)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }
}
