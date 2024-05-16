package com.example.medicalendar.controller;

import com.example.medicalendar.model.Profile;
import com.example.medicalendar.request.CreateProfileRequest;
import com.example.medicalendar.request.EditProfileRequest;
import com.example.medicalendar.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;
    @PostMapping("/create")
    public ResponseEntity<?> createProfile(@RequestBody CreateProfileRequest request) {
        try {
            Profile profile = profileService.createProfile(request);
            return new ResponseEntity<>(profile, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editProfile(@RequestBody EditProfileRequest request) {
        try {
            Profile updatedProfile = profileService.editProfile(request);
            return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
