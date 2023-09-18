package com.springbootapi.gestionpatient.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootapi.gestionpatient.entities.Medecin;
import com.springbootapi.gestionpatient.services.IMedecinService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MedecinController {

    private final IMedecinService ms;

    @GetMapping("/medecin")
    public String getAllMedecin(
            Model model,
            @RequestParam(name = "kw", defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Medecin> allMedecinPaginated = ms.getAllMedecinPaginated(keyword, PageRequest.of(page, size));

        model.addAttribute("data", allMedecinPaginated.getContent());
        model.addAttribute("kw", keyword);
        model.addAttribute("pages", new int[allMedecinPaginated.getTotalPages()]);
        model.addAttribute("current", page);

        return "medecin/medecinIndex";
    }

    @GetMapping("/addMedecin")
    public String addMedecinForm(Medecin medecin, Model model) {

        model.addAttribute("medecin", medecin);
        return "medecin/medecinForm";
    }

    @PostMapping("/addMedecin")
    public String addMedecin(
            @Valid @ModelAttribute Medecin medecin,
            BindingResult result) {

        if (result.hasErrors()) {
            return "medecin/medecinForm";
        }

        ms.addOrUpdateMedecin(medecin);
        return "redirect:/medecin";
    }

    @GetMapping("/updateMedecin")
    public String updateMedecinForm(@RequestParam("id") Long id, Model model) {

        Medecin medecin = ms.getMedecinById(id);
        model.addAttribute("medecin", medecin);
        return "medecin/medecinForm";
    }

    @PostMapping("/updateMedecin")
    public String updateMedecin(
            Model model,
            @Valid @ModelAttribute Medecin medecin,
            BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("medecin", medecin);
            return "medecin/medecinForm";
        }
        System.out.println(medecin);
        ms.addOrUpdateMedecin(medecin);
        return "redirect:/medecin";
    }

    @GetMapping("/deleteMedecin")
    public String deleteMedecin(@RequestParam("id") Long id) {

        ms.deleteMedecinById(id);
        return "redirect:/medecin";
    }
}
