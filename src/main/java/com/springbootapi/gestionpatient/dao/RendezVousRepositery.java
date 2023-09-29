package com.springbootapi.gestionpatient.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springbootapi.gestionpatient.entities.RendezVous;

public interface RendezVousRepositery extends JpaRepository<RendezVous, Long> {

    @Query("SELECT r FROM  RendezVous r WHERE r.dateRDV >=  :date  ")
    public Page<RendezVous> findByDateRDV(@Param("date") Date dateRDV, Pageable p);

    public Page<RendezVous> findByPatient_nom(String nom, Pageable p);

    public Page<RendezVous> findByMedecin_nom(String nom, Pageable p);
}
