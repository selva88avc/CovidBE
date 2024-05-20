package com.stackroute.userprofile.controller;

import com.stackroute.userprofile.model.UserProfile;
import com.stackroute.userprofile.model.User;
import com.stackroute.userprofile.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userprofile")
@Validated
public class UserProfileController {


    @Autowired
    UserProfileService userProfileService;

    @PostMapping("/save")
    public ResponseEntity<User> saveProduct(@RequestBody @Valid UserProfile userProfile){
        User user = userProfileService.saveProfile(userProfile);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateProduct(@RequestBody @Valid UserProfile userProfile, @RequestHeader Integer id){
        User user = userProfileService.updateProfile(userProfile, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
