package com.springbootapi.gestionpatient.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootapi.gestionpatient.entities.Patient;

public interface IPatientService {
    public void addOrUpdatePatient(Patient p);

    public void deletePatient(Long id);

    public Page<Patient> getallpatient(String kw, Pageable p);

    public Patient getPatientById(Long id);

    public List<Patient> getAllPatient();
}
