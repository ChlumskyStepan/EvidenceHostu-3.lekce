package com.engeto.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Rezervace {
    private List<Host> hosti;
    private List<Pokoj> pokoje;
    private LocalDate datumOd;
    private LocalDate datumDo;
    private TypPobytu typPobytu;


    //Formátování datumu na evropský zápis (samostatná konstanta)
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");


    public Rezervace(List<Host> hosti, List<Pokoj> pokoje, LocalDate datumOd, LocalDate datumDo, TypPobytu typPobytu) {
        this.hosti = hosti;
        this.pokoje = pokoje;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.typPobytu = typPobytu;
    }

    public List<Host> getHosti() {
        return hosti;
    }
    public List<Pokoj> getPokoje() {
        return pokoje;
    }
    public LocalDate getDatumOd() {
        return datumOd;
    }
    public LocalDate getDatumDo() {
        return datumDo;
    }
    public TypPobytu getTypPobytu() {
        return typPobytu;
    }

    @Override
    public String toString()  {

        //Použití StringBuilder pro efektivní modifikací a úpravu řetezců bez vytváření nových instancí
        //Metoda append jednoduše přidá zadaný rosah znaků k aktuální instanci
    StringBuilder builder = new StringBuilder();
        for (Host host : hosti) {
        builder.append(host.getJmeno())
                .append(" (")
                .append(host.getDatumNarozeni().format(formatter))
                .append(")")
                .append(", ");
    }
    String hostiString = builder.substring(0, builder.length() - 2);

    StringBuilder pokojeBuilder = new StringBuilder();
    for (Pokoj pokoj : pokoje) {
        pokojeBuilder.append("pokoj č. ").append(pokoj.getCislo()).append(", ");
    }

    String pokojeString = pokojeBuilder.substring(0, pokojeBuilder.length() - 2);

        return hostiString + " - " + pokojeString
            + " od " + datumOd.format(formatter)
            + " do " + datumDo.format(formatter)
                + ". Typ pobytu: "+ typPobytu.getPopis();


}

    public int getPocetHostu() {
        return 0;
    }
}

