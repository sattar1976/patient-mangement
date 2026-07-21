package com.pm.patientservice.controller;

import com.pm.patientservice.dto.validation.NewPatientValidationGroup;
import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name="patient", description = "This collection of APIs provide you the way to manage the Patients")
public class PatientController {

    private final PatientService patienceService;

    public PatientController (PatientService patienceService)
    {
        this.patienceService = patienceService;

    }


    @GetMapping
    @Operation(description = "Find all the Patients")
     public ResponseEntity <List<PatientResponseDTO>> findAllPatients() {

        List<PatientResponseDTO> patientDTOList= patienceService.findAllPatients();
        return ResponseEntity.ok().body(patientDTOList);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createNewPatient(@Validated({Default.class, NewPatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequest)
    {
        PatientResponseDTO responseDTO = patienceService.createNewPatient(patientRequest);
        return ResponseEntity.ok().body(responseDTO);

    }

    @PutMapping("/{ID}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID ID, @RequestBody PatientRequestDTO patientReqDT)
    {
        PatientResponseDTO responseDTO = patienceService.updatePatient(ID,patientReqDT);

        return ResponseEntity.ok().body(responseDTO);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID ID) {
        patienceService.deletePatient(ID);
        return ResponseEntity.noContent().build();
    }

    }
