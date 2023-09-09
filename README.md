# springboot-gestionpatient
Mini project server rendered managing patients web app with an exposed RESTful API

# Diagram Class

```mermaid
classDiagram
    class Patient
    Patient : -Long Id
    Patient : +String nom
    Patient : +String email

    class Medcin
    Medcin : -Long Id
    Medcin : +String nom
    Medcin : +String email
    Medcin : +String specialite

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
Medcin "1" -- "*" RendezVous