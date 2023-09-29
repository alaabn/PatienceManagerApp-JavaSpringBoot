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

import com.springbootapi.gestionpatient.entities.Patient;
import com.springbootapi.gestionpatient.services.IPatientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService ps;

    @GetMapping("/patient")
    public String getAllPatients(Model m,
            @RequestParam(name = "kw", defaultValue = "") String kw,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Patient> allPatientPaginated = ps.getallpatient(kw, PageRequest.of(page, size));

        m.addAttribute("data", allPatientPaginated.getContent());
        m.addAttribute("kw", kw);
        m.addAttribute("pages", new int[allPatientPaginated.getTotalPages()]);
        m.addAttribute("current", page);

        return "patient/patientIndex";
    }

    @GetMapping("/addPatient")
    public String addPatientForm(Patient p, Model m) {

        m.addAttribute("patient", p);
        return "patient/patientForm";
    }

    @PostMapping("/addPatient")
    public String addPatient(
            @Valid @ModelAttribute Patient patient,
            BindingResult result) {

        if (result.hasErrors()) {
            return "patient/patientForm";
        }

        ps.addOrUpdatePatient(patient);
        return "redirect:/patient";
    }

    @GetMapping("/updatePatient")
    public String UpdatePatientForm(@RequestParam("id") Long id, Model m) {

        Patient p = ps.getPatientById(id);
        m.addAttribute("patient", p);
        return "patient/patientForm";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(
            Model model,
            @Valid @ModelAttribute Patient patient,
            BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patient);
            return "patient/patientForm";
        }

        ps.addOrUpdatePatient(patient);
        return "redirect:/patient";
    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam("id") Long id) {

        ps.deletePatient(id);
        return "redirect:/Index";
    }

}
