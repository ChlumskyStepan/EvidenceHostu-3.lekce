package com.engeto.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Host {
    private String jmeno;
    private LocalDate datumNarozeni;

    public Host(String jmeno, LocalDate datumNarozeni) {
        this.jmeno = jmeno;
        this.datumNarozeni = datumNarozeni;
    }

    public String getJmeno() {
        return jmeno;
    }
    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    @Override

    public String toString() {
        // Formátování datumu na evropský zápis
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        return jmeno + " (" + datumNarozeni.format(formatter) + ")";
    }
}