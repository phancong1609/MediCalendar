package com.example.medicalendar.service;

import com.example.medicalendar.dtos.OfficeDTO;
import com.example.medicalendar.model.Office;
import com.example.medicalendar.model.ServiceType;
import com.example.medicalendar.repository.OfficeRepository;
import com.example.medicalendar.response.OfficeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfficeService {
    @Autowired
    OfficeRepository officeRepository;


    public OfficeResponse getAllOffice() throws Exception {
        List<Office> officeList = officeRepository.findAll();

        if (officeList.isEmpty()) {
            throw new Exception("There is no office");
        }

        List<OfficeDTO> officeDTOList = officeList.stream().map(this::convertToOfficeDTO).collect(Collectors.toList());
        OfficeResponse res = new OfficeResponse(officeDTOList);
        return res;
    }

    private OfficeDTO convertToOfficeDTO(Office office) {
        Set<ServiceType> serviceTypes = office.getServiceList().stream()
                .map(com.example.medicalendar.model.Service::getServiceType)
                .collect(Collectors.toSet());

        return new OfficeDTO(
                office.getId(),
                office.getLogo(),
                office.getName(),
                office.getAddress(),
                office.getDescription(),
                serviceTypes.stream().collect(Collectors.toList())
        );
    }
}
