package org.rusgidro.controllers;

import lombok.RequiredArgsConstructor;
import org.rusgidro.Service.EmployeeService;
import org.rusgidro.dto.JwtResponse;
import org.rusgidro.dto.LoginDTO;
import org.rusgidro.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
     private final JwtUtil jwtUtil;
     private final AuthenticationManager authenticationManager;
     private final EmployeeService employeeService;

     @PostMapping("/login")
     public ResponseEntity<?> getJwtToken(
             @RequestBody LoginDTO loginDTO
             ){
         try {

             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getPassword()));
         }catch (BadCredentialsException e){
             System.out.println(e);
             return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
         }

         UserDetails userDetails = employeeService.loadUserByUsername(loginDTO.getLogin());
         String token = jwtUtil.generateToken(userDetails);
         return ResponseEntity.ok(new JwtResponse(token, jwtUtil.getUserPosts(token).getFirst()));
     }
}
