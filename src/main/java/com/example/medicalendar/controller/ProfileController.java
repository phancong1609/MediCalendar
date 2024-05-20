package com.example.medicalendar.controller;

import com.example.medicalendar.model.Profile;
import com.example.medicalendar.request.CreateProfileRequest;
import com.example.medicalendar.request.EditProfileRequest;
import com.example.medicalendar.response.MessageResponse;
import com.example.medicalendar.response.ProfileResponse;
import com.example.medicalendar.response.TimeResponse;
import com.example.medicalendar.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;
    @PostMapping("/create")
    public ResponseEntity<MessageResponse> createProfileRequest(@RequestBody CreateProfileRequest request) {
        try {
            profileService.createProfile(request);
            MessageResponse response = new MessageResponse("Create Profile Successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            MessageResponse messageResponse = new MessageResponse(e.getMessage());
            return ResponseEntity.badRequest().body(messageResponse);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editProfileRequest(@RequestBody EditProfileRequest request) {
        try {
            profileService.editProfile(request);
            MessageResponse response = new MessageResponse("Edit Profile Successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            MessageResponse messageResponse = new MessageResponse(e.getMessage());
            return ResponseEntity.badRequest().body(messageResponse);
        }
    }

    @GetMapping("/getprofile/{paitient_email}")
    public ResponseEntity<ProfileResponse> getPatientProfileRequest(@PathVariable("paitient_email") String paitient_email) {
        try {
            ProfileResponse response = profileService.getPatientProfile(paitient_email);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ProfileResponse messageResponse = new ProfileResponse();
            messageResponse.setMessgage(e.getMessage());
            return ResponseEntity.badRequest().body(messageResponse);
        }
    }
}
