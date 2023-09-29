package com.springbootapi.gestionpatient.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapi.gestionpatient.entities.Patient;

public interface PatientRepositery extends JpaRepository<Patient, Long> {
    public Page<Patient> findByNomContains(String kw, Pageable p);
}
