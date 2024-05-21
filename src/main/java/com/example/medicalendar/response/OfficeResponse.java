package com.example.medicalendar.response;

import com.example.medicalendar.dtos.OfficeDTO;
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

    List<OfficeDTO> officeDTOS;

    public List<OfficeDTO> getOfficeDTOS() {
        return officeDTOS;
    }

    public void setOfficeDTOS(List<OfficeDTO> officeDTOS) {
        this.officeDTOS = officeDTOS;
    }

    public OfficeResponse(List<OfficeDTO> officeDTOS) {
        this.officeDTOS = officeDTOS;
    }
}
