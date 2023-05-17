package com.engeto.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rezervace {
    private Host host;
    private Pokoj pokoj;
    private LocalDate datumOd;
    private LocalDate datumDo;

    public Rezervace(Host host, Pokoj pokoj, LocalDate datumOd, LocalDate datumDo) {
        this.host = host;
        this.pokoj = pokoj;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public Host getHost() {
        return host;
    }
    public Pokoj getPokoj() {
        return pokoj;
    }
    public LocalDate getDatumOd() {
        return datumOd;
    }
    public LocalDate getDatumDo() {
        return datumDo;
    }

    @Override
    public String toString() {
        // Formátování datumu na evropský zápis
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        return host.getJmeno() + " (" + host.getDatumNarozeni().format(formatter) + ")"
                + " - pokoj č. " + pokoj.getCislo()
                + " od " + datumOd.format(formatter) + " do " + datumDo.format(formatter);
    }
}
