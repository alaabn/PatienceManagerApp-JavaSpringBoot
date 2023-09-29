package com.springbootapi.gestionpatient.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springbootapi.gestionpatient.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query("SELECT c FROM  Consultation c WHERE c.dateConsultation >=  :date  ")
    public Page<Consultation> findByDateConsultation(@Param("date") Date dateRDV, Pageable p);
}
