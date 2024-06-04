package org.rusgidro.controllers;

import lombok.RequiredArgsConstructor;
import org.rusgidro.Service.IndexTypeService;
import org.rusgidro.dto.TypesIndexResponseDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/indexTypes")
public class IndexTypeController {
    private final IndexTypeService indexTypeService;

    @GetMapping("/all")
    public List<TypesIndexResponseDTO> getAllTypes(){
        return indexTypeService.getAllIndexTypes();
    }
}
