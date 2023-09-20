package com.springbootapi.gestionpatient.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootapi.gestionpatient.entities.Consultation;

public interface IConsultationService {
    public void addOrUpdateConsultation(Consultation c);

    public Page<Consultation> getAllConsultationPaginated(Date date, Pageable p);

    public List<Consultation> getAllConsultation();

    public Consultation getConsultationById(Long id);

    public void deleteConsultationById(Long id);

    public Page<Consultation> filterConsultationByDate(Date date, Pageable p);
}
