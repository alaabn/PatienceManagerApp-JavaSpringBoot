package com.springbootapi.gestionpatient.restAPI;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapi.gestionpatient.entities.Patient;
import com.springbootapi.gestionpatient.services.IPatientService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientRestController {

    private final IPatientService ps;

    @GetMapping()
    public List<Patient> getAllPatients() {

        return ps.getAllPatient();
    }

    @PostMapping(consumes = "application/json")
    public void addPatient(@RequestBody Patient patient) {

        ps.addOrUpdatePatient(patient);
    }

    @PatchMapping()
    public void updatePatient(@RequestBody Patient patient) {

        ps.addOrUpdatePatient(patient);
    }

    @DeleteMapping()
    public void deletePatient(@RequestParam("id") Long id) {

        ps.deletePatient(id);
    }

}
