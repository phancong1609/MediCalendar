package com.example.medicalendar.response;

import com.example.medicalendar.model.Profile;

import java.util.List;

public class ProfileResponse {

    String messgage;

    List<Profile> profileList;

    public ProfileResponse() {

    }

    public String getMessgage() {
        return messgage;
    }

    public void setMessgage(String messgage) {
        this.messgage = messgage;
    }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public ProfileResponse(String messgage, List<Profile> profileList) {
        this.messgage = messgage;
        this.profileList = profileList;
    }
}
