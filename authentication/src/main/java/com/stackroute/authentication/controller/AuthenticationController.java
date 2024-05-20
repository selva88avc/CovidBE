package com.stackroute.authentication.controller;

import com.stackroute.authentication.model.Credentials;
import com.stackroute.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RequestMapping("/authentication")
@RestController
@Validated
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<?> authorize(@RequestBody Credentials credentials){
        Map<String,String> token = authenticationService.generateToken(credentials);
        return new ResponseEntity<Map<String,String>>(token,HttpStatus.OK);
    }
}
