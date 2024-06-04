package org.rusgidro.controllers;

import lombok.RequiredArgsConstructor;
import org.rusgidro.Service.EmployeeService;
import org.rusgidro.dto.RegisterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RegisterDTO registerDTO){

        System.out.println(registerDTO);
        if(employeeService.registerNewUser(registerDTO)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        System.out.println("Ошибка");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
