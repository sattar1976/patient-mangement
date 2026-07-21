package com.pm.patientservice.utiil;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

   public static PatientResponseDTO toDTO (Patient p)
    {
        PatientResponseDTO pDTO = new PatientResponseDTO();
        pDTO.setAddress(p.getAddress());
        pDTO.setEmail(p.getEmail());
        pDTO.setDateOfBirth(p.getDateOfBirth().toString());
        pDTO.setID(p.getId().toString());
        pDTO.setRegisteredDate(p.getRegisteredDate().toString());
        pDTO.setName(p.getName());
        return pDTO;

    }

    public static Patient toModel(PatientRequestDTO patientDTO)
    {
        Patient patientEntity = new Patient();
        patientEntity.setName(patientDTO.getName());
        patientEntity.setEmail(patientDTO.getEmail());
        patientEntity.setDateOfBirth(LocalDate.parse(patientDTO.getDateOfBirth()));
        patientEntity.setAddress(patientDTO.getAddress());
        patientEntity.setRegisteredDate(LocalDate.parse(patientDTO.getRegisteredDate()));
        return  patientEntity;
    }
}
