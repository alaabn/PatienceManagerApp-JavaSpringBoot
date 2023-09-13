package com.springbootapi.gestionpatient.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootapi.gestionpatient.entities.RendezVous;

public interface IRendezVousService {
    public void addOrUpdateRendezVous(RendezVous r);

    public void deleteRendezVous(Long id);

    public Page<RendezVous> getallRendezVous(Pageable p);

    public RendezVous getRendezVousById(Long id);

    public Page<RendezVous> getRendezVousByDate(Date dateRDV, Pageable p);
}
