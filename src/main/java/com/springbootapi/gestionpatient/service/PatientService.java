package com.springbootapi.gestionpatient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootapi.gestionpatient.dao.PatientRepositery;
import com.springbootapi.gestionpatient.entities.Patient;

public class PatientService implements IPatientService {

    @Autowired
    PatientRepositery pr;

    @Override
    public void addOrUpdatePatient(Patient p) {
        pr.save(p);
    }

    @Override
    public void deletePatient(Long id) {
        pr.deleteById(id);
    }

    @Override
    public Page<Patient> getallpatient(String kw, Pageable p) {
        return pr.findByNomContains(kw, p);
    }

    @Override
    public Patient getPatientById(Long id) {
        return pr.findById(id).get();
    }

}
