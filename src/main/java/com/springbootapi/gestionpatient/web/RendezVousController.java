package com.springbootapi.gestionpatient.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootapi.gestionpatient.entities.RendezVous;
import com.springbootapi.gestionpatient.service.IRendezVousService;

@Controller
public class RendezVousController {

    @Autowired
    IRendezVousService pr;

    @GetMapping("/addRendezVous")
    public String addRendezVous(RendezVous r, Model m) {
        m.addAttribute("rendezVousData", r);
        return "rendezVousform";
    }

    @GetMapping("/updateRendezVous")
    public String updateRendezVous(@RequestParam("id") Long id, Model m) {
        RendezVous r = pr.getRendezVousById(id);
        m.addAttribute("RendezVousVar", pr);
        return "RendezVousIndex";
    }

    @GetMapping("/deleteRendezVous")
    public String deleteRendezVous(@RequestParam("id") Long id) {
        pr.deleteRendezVous(id);
        return "redirect/Index";
    }

    @GetMapping("/RendezVous")
    public String getAllRendezVous(Model m,
            @RequestParam(name = "RDV", defaultValue = "") Date dateRDV,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<RendezVous> pageRendezVous = pr.getRendezVousByDate(dateRDV, PageRequest.of(page, size));
        m.addAttribute("data", pageRendezVous.getContent());
        m.addAttribute("date", dateRDV);
        m.addAttribute("pages", new int[pageRendezVous.getTotalPages()]);
        m.addAttribute("current", page);
        return "viewRendezVous";
    }
}
