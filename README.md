# Gestionpatient
Mini project using Springboot 3 server rendered managing patients web app with an exposed RESTful API

# Diagram Class

```mermaid
classDiagram
    class Patient
    Patient : -Long Id
    Patient : +String nom
    Patient : +String email

    class Medecin
    Medecin : -Long Id
    Medecin : +String nom
    Medecin : +String email
    Medecin : +String specialite

    class RendezVous
    RendezVous : -Long Id
    RendezVous : +Date dateRDV
    RendezVous : +Date heureRDV

    class Consultation
    Consultation : -Long Id
    Consultation : +Date dateConsultation
    Consultation : +String rapportConsultation

RendezVous "1" -- "1" Consultation
Patient "1" -- "*" RendezVous
Medecin "1" -- "*" RendezVous
