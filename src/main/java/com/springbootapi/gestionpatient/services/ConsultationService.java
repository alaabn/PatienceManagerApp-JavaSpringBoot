package com.springbootapi.gestionpatient.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootapi.gestionpatient.dao.ConsultationRepository;
import com.springbootapi.gestionpatient.entities.Consultation;

@Service
public class ConsultationService implements IConsultationService {

    @Autowired
    ConsultationRepository cr;

    @Override
    public void addOrUpdateConsultation(Consultation c) {
        cr.save(c);
    }

    @Override
    public Page<Consultation> getAllConsultationPaginated(Date date, Pageable p) {
        return cr.findByDateConsultation(date, p);
    }

    @Override
    public Consultation getConsultationById(Long id) {
        return cr.findById(id).get();
    }

    @Override
    public void deleteConsultationById(Long id) {
        cr.deleteById(id);
    }

    @Override
    public Page<Consultation> filterConsultationByDate(Date date, Pageable p) {
        return cr.findByDateConsultation(date, p);
    }

}
