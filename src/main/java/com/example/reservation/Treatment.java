package com.example.reservation;


import jakarta.persistence.*;
@Entity
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String treatment;

    @Enumerated(EnumType.STRING)
    private Treatments treatments;

    private int treatmentTime;

//    public String getTreatment() {
//        return treatment;
//    }
//
//    public void setTreatment(String treatment) {
//        this.treatment = treatment;
//    }

    public Treatment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Treatments getTreatments() {
        return treatments;
    }

    public void setTreatments(Treatments treatments) {
        this.treatments = treatments;
    }

    public int getTreatmentTime() {
        return treatmentTime;
    }

    public void setTreatmentTime(int treatmenttime) {
        this.treatmentTime = treatmenttime;
    }
}
