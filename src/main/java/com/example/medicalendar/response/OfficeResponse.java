package com.example.medicalendar.response;

import com.example.medicalendar.model.Office;

import java.util.List;

public class OfficeResponse {

    String message;

    public String getMessage() {
        return message;
    }

    public OfficeResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OfficeResponse(String message, List<Office> officeList) {
        this.message = message;
        this.officeList = officeList;
    }

    List<Office> officeList;

    public OfficeResponse(List<Office> officeList) {
        this.officeList = officeList;
    }

    public List<Office> getOfficeList() {
        return officeList;
    }

    public void setOfficeList(List<Office> officeList) {
        this.officeList = officeList;
    }
}
