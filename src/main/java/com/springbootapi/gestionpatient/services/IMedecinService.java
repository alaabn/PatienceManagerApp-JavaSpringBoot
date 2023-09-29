package com.springbootapi.gestionpatient.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootapi.gestionpatient.entities.Medecin;

public interface IMedecinService {
    public void addOrUpdateMedecin(Medecin m);

    public Page<Medecin> getAllMedecinPaginated(String kw, Pageable p);

    public Medecin getMedecinById(Long id);

    public void deleteMedecinById(Long id);

    public List<Medecin> getAllMedecin();
}
