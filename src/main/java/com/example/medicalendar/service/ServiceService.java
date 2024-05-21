package com.example.medicalendar.service;

import com.example.medicalendar.dtos.DoctorDTO;
import com.example.medicalendar.model.Office;

import com.example.medicalendar.model.ServiceType;
import com.example.medicalendar.repository.OfficeRepository;
import com.example.medicalendar.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceService {
    @Autowired
    private OfficeRepository officeRepository;

    public List<ServiceResponse> getServicesByOfficeIdAndType(Long officeId, ServiceType serviceType) {
        Office office = officeRepository.findById(officeId).orElse(null);
        if (office != null) {
            return office.getServiceList().stream()
                    .filter(service -> service.getServiceType() == serviceType)
                    .map(this::convertToServiceResponse)
                    .collect(Collectors.toList());
        }
        return null; // or throw an exception if office not found
    }

    private ServiceResponse convertToServiceResponse(com.example.medicalendar.model.Service service) {
        List<DoctorDTO> doctorDTOs = service.getDoctorList().stream()
                .map(doctor -> new DoctorDTO(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getGender(),
                        doctor.getBookingPrice(),
                        doctor.getSpeciality().getId()))
                .collect(Collectors.toList());

        return new ServiceResponse(
                service.getId(),
                service.getName(),
                service.getServiceType().name(),
                service.getDescription(),
                service.getRemind(),
                doctorDTOs);
    }
}
