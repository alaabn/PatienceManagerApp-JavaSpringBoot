package com.springbootapi.gestionpatient.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapi.gestionpatient.entities.RendezVous;

public interface RendezVousRepositery extends JpaRepository<RendezVous, Long> {
    public Page<RendezVous> findByDateRDV(Date dateRDV, Pageable p);
}
