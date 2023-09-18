package com.springbootapi.gestionpatient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootapi.gestionpatient.dao.MedecinRepository;
import com.springbootapi.gestionpatient.entities.Medecin;

@Service
public class MedecinService implements IMedecinService {

    @Autowired
    MedecinRepository mr;

    @Override
    public void addOrUpdateMedecin(Medecin m) {
        mr.save(m);
    }

    @Override
    public Page<Medecin> getAllMedecinPaginated(String kw, Pageable p) {
        return mr.findByNomContains(kw, p);
    }

    @Override
    public Medecin getMedecinById(Long id) {
        return mr.findById(id).get();
    }

    @Override
    public void deleteMedecinById(Long id) {
        mr.deleteById(id);
    }

    @Override
    public List<Medecin> getAllMedecin() {
        return mr.findAll();
    }
}
