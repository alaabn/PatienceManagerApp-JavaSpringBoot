package com.springbootapi.gestionpatient.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapi.gestionpatient.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    public Page<Medecin> findByNomContains(String kw, Pageable p);
}
