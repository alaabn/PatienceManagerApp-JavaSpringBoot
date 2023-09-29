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

import com.springbootapi.gestionpatient.entities.Consultation;
import com.springbootapi.gestionpatient.entities.RendezVous;
import com.springbootapi.gestionpatient.services.IConsultationService;
import com.springbootapi.gestionpatient.services.IRendezVousService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ConsultationController {

    private final IConsultationService cs;
    private final IRendezVousService rs;

    @GetMapping("/consultation")
    public String getAllMedecin(
            Model model,
            @RequestParam(name = "date", defaultValue = "1990-11-1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Consultation> allConsultationPaginated = cs.getAllConsultationPaginated(date, PageRequest.of(page, size));

        model.addAttribute("data", allConsultationPaginated.getContent());
        model.addAttribute("date", date);
        model.addAttribute("pages", new int[allConsultationPaginated.getTotalPages()]);
        model.addAttribute("current", page);

        return "consultation/consultationIndex";
    }

    @GetMapping("/addConsultation")
    public String addConsultationForm(Consultation consultation, Model model) {

        List<RendezVous> allRendezVous = rs.getAllRendezVous();

        model.addAttribute("consultation", consultation);
        model.addAttribute("allRendezVous", allRendezVous);

        return "consultation/consultationForm";
    }

    @PostMapping("/addConsultation")
    public String addConsultation(
            Model model,
            @Valid @ModelAttribute Consultation consultation,
            BindingResult result) {

        if (result.hasErrors()) {
            List<RendezVous> allRendezVous = rs.getAllRendezVous();
            model.addAttribute("allRendezVous", allRendezVous);
            return "consultation/consultationForm";
        }

        cs.addOrUpdateConsultation(consultation);
        return "redirect:/consultation";
    }

    @GetMapping("/updateConsultation")
    public String updateConsultationForm(@RequestParam("id") Long id, Model model) {

        Consultation consultation = cs.getConsultationById(id);
        List<RendezVous> allRendezVous = rs.getAllRendezVous();

        model.addAttribute("allRendezVous", allRendezVous);
        model.addAttribute("consultation", consultation);
        return "consultation/consultationForm";
    }

    @PostMapping("/updateConsultation")
    public String updateConsultation(
            Model model,
            @Valid @ModelAttribute Consultation consultation,
            BindingResult result) {

        if (result.hasErrors()) {
            List<RendezVous> allRendezVous = rs.getAllRendezVous();
            model.addAttribute("allRendezVous", allRendezVous);
            model.addAttribute("consultation", consultation);
            return "consultation/consultationForm";
        }

        cs.addOrUpdateConsultation(consultation);
        return "redirect:/consultation";
    }

    @GetMapping("/deleteConsultation")
    public String deleteConsultation(@RequestParam("id") Long id) {

        cs.deleteConsultationById(id);
        return "redirect:/consultation";
    }
}
