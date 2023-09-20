package com.springbootapi.gestionpatient.restAPI;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapi.gestionpatient.entities.Consultation;
import com.springbootapi.gestionpatient.services.IConsultationService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/api/consultation")
@RequiredArgsConstructor
public class ConsultationRestController {

    private final IConsultationService cs;

    @GetMapping()
    public List<Consultation> getAllConsultations() {

        return cs.getAllConsultation();
    }

    @PostMapping()
    public void addConsultation(@RequestBody Consultation consultation) {

        cs.addOrUpdateConsultation(consultation);
    }

    @PatchMapping()
    public void updatePatient(@RequestBody Consultation consultation) {

        cs.addOrUpdateConsultation(consultation);
    }

    @DeleteMapping()
    public void deleteConsultation(@RequestParam("id") Long id) {

        cs.deleteConsultationById(id);
    }
}
