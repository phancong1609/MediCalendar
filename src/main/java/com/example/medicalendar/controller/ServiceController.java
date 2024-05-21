package com.example.medicalendar.controller;

import com.example.medicalendar.model.Service;
import com.example.medicalendar.model.ServiceType;
import com.example.medicalendar.response.ServiceResponse;
import com.example.medicalendar.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @GetMapping("/byOfficeAndType")
    public List<ServiceResponse> getServicesByOfficeIdAndType(@RequestParam Long officeId, @RequestParam ServiceType serviceType) {
        return serviceService.getServicesByOfficeIdAndType(officeId, serviceType);
    }
}
