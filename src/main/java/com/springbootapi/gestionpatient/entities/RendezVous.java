package com.springbootapi.gestionpatient.entities;


import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVous {
    private Long id;
    private Date dateRDV;
    private Date heureRDV;
}
