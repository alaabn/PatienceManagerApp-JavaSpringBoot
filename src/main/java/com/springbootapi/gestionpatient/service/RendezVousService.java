package com.springbootapi.gestionpatient.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootapi.gestionpatient.dao.RendezVousRepositery;
import com.springbootapi.gestionpatient.entities.RendezVous;

public class RendezVousService implements IRendezVousService {

    @Autowired
    RendezVousRepositery pr;

    @Override
    public void addOrUpdateRendezVous(RendezVous r) {
        pr.save(r);
    }

    @Override
    public void deleteRendezVous(Long id) {
        pr.deleteById(id);
    }

    @Override
    public Page<RendezVous> getallRendezVous(Pageable p) {
        return pr.findAll(p);
    }

    @Override
    public RendezVous getRendezVousById(Long id) {
        return pr.findById(id).get();
    }

    @Override
    public Page<RendezVous> getRendezVousByDate(Date dateRDV, Pageable p) {
        return pr.findByDateRDV(dateRDV, p);
    }

}
