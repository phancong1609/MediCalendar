package com.example.medicalendar.service;

import com.example.medicalendar.model.Patient;
import com.example.medicalendar.model.Profile;
import com.example.medicalendar.repository.PatientRepository;
import com.example.medicalendar.repository.ProfileRepository;
import com.example.medicalendar.request.CreateProfileRequest;
import com.example.medicalendar.request.EditProfileRequest;
import com.example.medicalendar.response.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    PatientRepository patientRepository;

    public void createProfile(CreateProfileRequest request) {
        if (profileRepository.existsByIdNumber(request.getIdNumber())) {
            throw new IllegalArgumentException("ID number already exists");
        }
        if (profileRepository.existsByIdHealthInsurance(request.getIdHealthInsurance())) {
            throw new IllegalArgumentException("Health insurance ID already exists");
        }

        Patient p = patientRepository.findByEmail(request.getPatientEmail());

        if (p == null) {
            throw new IllegalArgumentException("Patient not exist");
        }

        Profile profile = new Profile();
        profile.setName(request.getName());
        profile.setBirthdate(request.getBirthdate());
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

        p.getProfileList().add(profile);
        profileRepository.save(profile);
        patientRepository.save(p);
    }

    public void editProfile(EditProfileRequest request) {
        Optional<Profile> optionalProfile = profileRepository.findById(request.getId());
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();

            profile.setName(request.getName());
            profile.setBirthdate(request.getBirthdate());
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

            profileRepository.save(profile);
        } else {
            throw new IllegalArgumentException("Profile not found with id: " + request.getId());
        }
    }


    public ProfileResponse getPatientProfile(String paitientEmail) {
        Patient p = patientRepository.findByEmail(paitientEmail);
        ProfileResponse res = new ProfileResponse();
        res.setProfileList(p.getProfileList());
        return res;
    }

}
