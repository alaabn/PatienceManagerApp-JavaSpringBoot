package com.springbootapi.gestionpatient.entities;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "la date du rendez-vous doit être dans le futur")
    private Date dateRDV;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime heureRDV;

    @JsonBackReference("patientRef")
    @ManyToOne(targetEntity = Patient.class, fetch = FetchType.LAZY, optional = true)
    private Patient patient;

    @JsonBackReference("medecinRef")
    @ManyToOne(targetEntity = Medecin.class, fetch = FetchType.LAZY, optional = true)
    private Medecin medecin;

    @JsonBackReference("consultationRef")
    @OneToOne(mappedBy = "rendezVous", targetEntity = Consultation.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Consultation consultation;
}
