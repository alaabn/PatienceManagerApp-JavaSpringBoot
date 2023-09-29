package com.springbootapi.gestionpatient.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootapi.gestionpatient.dao.RendezVousRepositery;
import com.springbootapi.gestionpatient.entities.RendezVous;

@Service
public class RendezVousService implements IRendezVousService {

    @Autowired
    RendezVousRepositery rr;

    @Override
    public void addOrUpdateRendezVous(RendezVous r) {
        rr.save(r);
    }

    @Override
    public void deleteRendezVous(Long id) {
        rr.deleteById(id);
    }

    @Override
    public Page<RendezVous> getallRendezVous(Pageable p) {
        return rr.findAll(p);
    }

    @Override
    public RendezVous getRendezVousById(Long id) {
        return rr.findById(id).get();
    }

    @Override
    public Page<RendezVous> getRendezVousByDate(Date dateRDV, Pageable p) {
        return rr.findByDateRDV(dateRDV, p);
    }

    @Override
    public List<RendezVous> getAllRendezVous() {
        return rr.findAll();

    }

}
