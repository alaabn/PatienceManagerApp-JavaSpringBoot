package com.springbootapi.gestionpatient.entities;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
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
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "la date de la consultation doit être aujourd'hui ou dans le futur")
    private Date dateConsultation;
    @Pattern(regexp = "[^[A-Za-z]+[\\s]{1}]+", message = "le nom complet ne contient que des mots alphabétiques commençant par une majuscule. example: Enis Hachicha")
    private String rapportConsultation;
    @Max(value = 100)
    private BigDecimal prixConsultation;

    @JsonManagedReference("consultationRef")
    @OneToOne(targetEntity = RendezVous.class, fetch = FetchType.LAZY, orphanRemoval = true)
    private RendezVous rendezVous;
}
