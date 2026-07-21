package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.exceptions.EmailAlreadyExistsException;
import com.pm.patientservice.exceptions.PatientNotFoundException;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import com.pm.patientservice.utiil.PatientMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepo)
    {
        patientRepository = patientRepo;
    }

    public List<PatientResponseDTO> findAllPatients()
    {
        List <Patient> patientList= patientRepository.findAll();
        return patientList.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO createNewPatient(PatientRequestDTO pReqDTO)
    {
        Patient patient = PatientMapper.toModel(pReqDTO);
        patientRepository.save(patient);
        return PatientMapper.toDTO(patient);
    }

    public PatientResponseDTO updatePatient( UUID uuid,PatientRequestDTO pReqDTO)
    {
       // UUID uid = UUID.fromString(pReqDTO.getID());
       Patient patient = patientRepository.findById(uuid).orElseThrow(()->
               new PatientNotFoundException("Patient Not Found for update"+pReqDTO.getID()));
       if (!patient.getEmail().equals(pReqDTO.getEmail()))
        {
            if (patientRepository.existsByEmail(pReqDTO.getEmail()))
            {
                throw new EmailAlreadyExistsException("Email Already Exists"+ pReqDTO.getEmail());
            }
        }

patient.setName(pReqDTO.getName());
        patient.setAddress(pReqDTO.getAddress());
patient.setEmail(pReqDTO.getEmail());
patient.setName(pReqDTO.getName());

        patient.setDateOfBirth(LocalDate.parse(pReqDTO.getDateOfBirth()));
       Patient updatedPatient =  patientRepository.save(patient);
      return PatientMapper.toDTO(updatedPatient);
    }

    public void deletePatient(UUID id) {
//        Patient patient = patientRepository.findById(uuid).orElseThrow(()->
//                new PatientNotFoundException("Patient Not Found for update"+id));
         patientRepository.deleteById(id);
    }
}
