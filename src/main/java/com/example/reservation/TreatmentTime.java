package com.example.reservation;

public enum TreatmentTime {

    HALF_HOUR("30 minut"),
    ONE_HOUR("1 godzina"),
    QUATER_OF_AN_HOUR("Kwadrans"),
    FORTY_FIVE_MINUTES("45 minut"),
    EIGHTY("80 minut");

    private final String translation;

    TreatmentTime(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return translation;
    }

}
