package com.springbootapi.gestionpatient.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    private Long id;
    private Date dateConsultation;
    private String rapportConsultation;
    private Double prixConsultation;
}
