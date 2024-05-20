package com.example.medicalendar.service;

import com.example.medicalendar.model.Office;
import com.example.medicalendar.repository.OfficeRepository;
import com.example.medicalendar.response.OfficeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {
    @Autowired
    OfficeRepository officeRepository;


    public OfficeResponse getAllOffice() throws Exception {
        List<Office> officeList = officeRepository.findAll();

        if (officeList.isEmpty()) {
            throw new Exception("There is no office");
        }

        OfficeResponse res = new OfficeResponse(officeList);
        return  res;
    }
}
