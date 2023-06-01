package com.engeto.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Host {
    private final String jmeno;
    private final LocalDate datumNarozeni;

    //Formátování datumu na evropský zápis (samostatná konstanta)
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

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
        return jmeno + " (" + datumNarozeni.format(formatter) + ")";
    }
}