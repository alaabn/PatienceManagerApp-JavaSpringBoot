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

import com.springbootapi.gestionpatient.entities.RendezVous;
import com.springbootapi.gestionpatient.services.IRendezVousService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/api/rendezVous")
@RequiredArgsConstructor
public class RendezVousRestController {

    private final IRendezVousService rs;

    @GetMapping()
    public List<RendezVous> getAllRendezVous() {

        return rs.getAllRendezVous();
    }

    @PostMapping()
    public void addRendezVous(@RequestBody RendezVous rendezVous) {

        rs.addOrUpdateRendezVous(rendezVous);
    }

    @PatchMapping()
    public void updateRendezVous(@RequestBody RendezVous rendezVous) {

        rs.addOrUpdateRendezVous(rendezVous);
    }

    @DeleteMapping()
    public void deleteRendezVous(@RequestParam("id") Long id) {

        rs.deleteRendezVous(id);
    }

}
