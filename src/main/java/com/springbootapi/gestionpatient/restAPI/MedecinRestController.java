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

import com.springbootapi.gestionpatient.entities.Medecin;
import com.springbootapi.gestionpatient.services.IMedecinService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/api/medecin")
@RequiredArgsConstructor
public class MedecinRestController {

    private final IMedecinService ms;

    @GetMapping()
    public List<Medecin> getAllMedecins() {

        return ms.getAllMedecin();
    }

    @PostMapping()
    public void addMedecin(@RequestBody Medecin medecin) {

        ms.addOrUpdateMedecin(medecin);
    }

    @PatchMapping()
    public void updateMedecin(@RequestBody Medecin medecin) {

        ms.addOrUpdateMedecin(medecin);
    }

    @DeleteMapping()
    public void deleteMedecin(@RequestParam("id") Long id) {

        ms.deleteMedecinById(id);
    }
}
