package com.springbootapi.gestionpatient.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medcin {
    private int id;
    private String nom;
    private String email;
    private String specialite;
}
