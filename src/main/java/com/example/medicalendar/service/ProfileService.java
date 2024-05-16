package com.example.medicalendar.service;

import com.example.medicalendar.model.Profile;
import com.example.medicalendar.repository.ProfileRepository;
import com.example.medicalendar.request.CreateProfileRequest;
import com.example.medicalendar.request.EditProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(CreateProfileRequest request) {
        // Check for duplicate idNumber, idHealthInsurance, and phone
        if (profileRepository.existsByIdNumber(request.getIdNumber())) {
            throw new IllegalArgumentException("ID number already exists");
        }
        if (profileRepository.existsByIdHealthInsurance(request.getIdHealthInsurance())) {
            throw new IllegalArgumentException("Health insurance ID already exists");
        }


        // Create profile entity
        Profile profile = new Profile();
        profile.setName(request.getName());
        profile.setBirthdate(request.getBirthdate());
        profile.setRegisterDate(request.getRegisterDate());
        profile.setGender(request.getGender());
        profile.setIdNumber(request.getIdNumber());
        profile.setIdHealthInsurance(request.getIdHealthInsurance());
        profile.setJob(request.getJob());
        profile.setPhone(request.getPhone());
        profile.setNation(request.getNation());
        profile.setEthnicGroup(request.getEthnicGroup());
        profile.setProvince(request.getProvince());
        profile.setDistrict(request.getDistrict());
        profile.setWard(request.getWard());
        profile.setAddressNumber(request.getAddressNumber());

        // Save profile to database
        return profileRepository.save(profile);
    }

    public Profile editProfile(EditProfileRequest request) {
        Optional<Profile> optionalProfile = profileRepository.findById(request.getId());
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();

            profile.setName(request.getName());
            profile.setBirthdate(request.getBirthdate());
            profile.setRegisterDate(request.getRegisterDate());
            profile.setGender(request.getGender());
            profile.setIdNumber(request.getIdNumber());
            profile.setIdHealthInsurance(request.getIdHealthInsurance());
            profile.setJob(request.getJob());
            profile.setPhone(request.getPhone());
            profile.setNation(request.getNation());
            profile.setEthnicGroup(request.getEthnicGroup());
            profile.setProvince(request.getProvince());
            profile.setDistrict(request.getDistrict());
            profile.setWard(request.getWard());
            profile.setAddressNumber(request.getAddressNumber());

            // Save updated profile
            return profileRepository.save(profile);
        } else {
            throw new IllegalArgumentException("Profile not found with id: " + request.getId());
        }
    }
}
