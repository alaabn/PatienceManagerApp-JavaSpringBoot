package com.springbootapi.gestionpatient.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootapi.gestionpatient.entities.Patient;
import com.springbootapi.gestionpatient.service.IPatientService;

@Controller
public class PatientController {

    @Autowired
    IPatientService ps;

    @GetMapping("/addPatient")
    public String addPatient(Patient p, Model m) {
        m.addAttribute("patientData", p);
        return "patientform";
    }

    @GetMapping("/updatePatient")
    public String UpdatePatient(@RequestParam("id") Long id, Model m) {
        Patient p = ps.getPatientById(id);
        m.addAttribute("patientVar", p);
        return "patientIndex";
    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam("id") Long id) {
        ps.deletePatient(id);
        return "redirect:/Index";
    }

    @GetMapping("/Patient")
    public String getAllPatients(Model m,
            @RequestParam(name = "ps", defaultValue = "") String p,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<Patient> pagePatients = ps.getallpatient(p, PageRequest.of(page, size));
        m.addAttribute("data", pagePatients.getContent());
        m.addAttribute("p", p);
        m.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        m.addAttribute("current", page);
        return "viewPatient";
    }
}
