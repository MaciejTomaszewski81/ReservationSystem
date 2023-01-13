package com.example.reservation;

public enum Treatments {
    PHYSIOTHERAPY_CONSULTATION("Konsultacja fizjoterapeutyczna"),
    INDIVIDUAL_THERAPY("Terapia indywidualna"),
    CLASSIC_MASSAGE("Masaż klasyczny"),
    DEEP_MASSAGE("Masaż głęboki"),
    UROGYNECOLOGICAL_CONSULTATION("Konsultacja uroginekologiczna"),
    UROGYNECOLOGICAL_THERAPY("Terapia uroginekologiczna"),
    KINESIOLOGY_TAPING("Kinesiology Taping"),
    EXERCISE_INSTRUCTIONS("Instruktaż ćwiczeń");

    private final String translation;

    Treatments(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return translation;
    }

}
