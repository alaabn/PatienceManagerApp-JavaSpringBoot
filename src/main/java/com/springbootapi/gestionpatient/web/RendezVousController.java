package com.springbootapi.gestionpatient.web;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootapi.gestionpatient.entities.Medecin;
import com.springbootapi.gestionpatient.entities.Patient;
import com.springbootapi.gestionpatient.entities.RendezVous;
import com.springbootapi.gestionpatient.services.IMedecinService;
import com.springbootapi.gestionpatient.services.IPatientService;
import com.springbootapi.gestionpatient.services.IRendezVousService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RendezVousController {

    private final IRendezVousService rs;
    private final IPatientService ps;
    private final IMedecinService ms;

    @GetMapping("/rendezVous")
    public String getAllRendezVous(
            Model model,
            @RequestParam(name = "rdv", defaultValue = "1990-11-1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateRDV,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<RendezVous> pageRendezVous = rs.getRendezVousByDate(dateRDV, PageRequest.of(page, size));

        model.addAttribute("data", pageRendezVous.getContent());
        model.addAttribute("date", dateRDV);
        model.addAttribute("pages", new int[pageRendezVous.getTotalPages()]);
        model.addAttribute("current", page);

        return "rendezVous/rendezVousIndex";
    }

    @GetMapping("/addRendezVous")
    public String addRendezVousForm(RendezVous rendezVous, Model model) {

        List<Medecin> medecinSelectOptions = ms.getAllMedecin();
        List<Patient> patientSelectOptions = ps.getAllPatient();

        model.addAttribute("rendezVous", rendezVous);
        model.addAttribute("medecins", medecinSelectOptions);
        model.addAttribute("patients", patientSelectOptions);
        return "rendezVous/rendezVousForm";
    }

    @PostMapping("/addRendezVous")
    public String addRendezVous(
            Model model,
            @Valid @ModelAttribute RendezVous rendezVous,
            BindingResult result) {

        if (result.hasErrors()) {
            List<Medecin> medecinSelectOptions = ms.getAllMedecin();
            List<Patient> patientSelectOptions = ps.getAllPatient();

            model.addAttribute("medecins", medecinSelectOptions);
            model.addAttribute("patients", patientSelectOptions);
            return "rendezVous/rendezVousForm";
        }

        rs.addOrUpdateRendezVous(rendezVous);
        return "redirect:/rendezVous";
    }

    @GetMapping("/updateRendezVous")
    public String updateRendezVousForm(@RequestParam("id") Long id, Model model) {

        List<Medecin> medecinSelectOptions = ms.getAllMedecin();
        List<Patient> patientSelectOptions = ps.getAllPatient();
        RendezVous rendezVous = rs.getRendezVousById(id);

        model.addAttribute("rendezVous", rendezVous);
        model.addAttribute("medecins", medecinSelectOptions);
        model.addAttribute("patients", patientSelectOptions);

        return "rendezVous/rendezVousForm";
    }

    @PostMapping("/updateRendezVous")
    public String updateRendezVous(
            @Valid @ModelAttribute RendezVous rendezVous,
            BindingResult result) {

        if (result.hasErrors()) {
            return "rendezVous/rendezVousForm";
        }

        rs.addOrUpdateRendezVous(rendezVous);
        return "redirect:/rendezVous";
    }

    @GetMapping("/deleteRendezVous")
    public String deleteRendezVous(@RequestParam("id") Long id) {
        rs.deleteRendezVous(id);
        return "redirect:/rendezVous";
    }

}
