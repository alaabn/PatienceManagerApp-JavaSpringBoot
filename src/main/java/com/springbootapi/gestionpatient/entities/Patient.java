package com.springbootapi.gestionpatient.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "[^[A-Z][a-z]+[\\s]{1}]+", message = "le nom complet ne contient que des mots alphabétiques commençant par une majuscule. example: Enis Hachicha")
    @NotEmpty(message = "veuillez entrer votre nom")
    private String nom;
    @Email(message = "veuillez entrer un email valide")
    @NotEmpty(message = "veuillez entrer votre email")
    private String email;

    @JsonManagedReference("patientRef")
    @OneToMany(mappedBy = "patient", targetEntity = RendezVous.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RendezVous> rendezVous = new ArrayList<RendezVous>();
}
