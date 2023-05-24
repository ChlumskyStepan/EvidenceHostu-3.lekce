package com.engeto.hotel;

public enum TypPobytu {
    REKREACNI("Rekreační pobyt"),
    PRACOVNI("Pracovní pobyt");

    private String popis;

    TypPobytu(String popis) {
        this.popis = popis;
    }

    public String getPopis() {
        return popis;
    }
}
