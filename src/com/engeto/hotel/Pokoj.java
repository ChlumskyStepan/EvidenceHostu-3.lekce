package com.engeto.hotel;

public class Pokoj {
    private int cislo;
    private double cena;
    private int pocetLuzek;
    private boolean balkon;
    private boolean vyhledNaMore;
    public Pokoj(int cislo, int pocetLuzek, int cena, boolean balkon, boolean vyhledNaMore) {
        this.cislo = cislo;
        this.pocetLuzek = pocetLuzek;
        this.cena = cena;
        this.balkon = balkon;
        this.vyhledNaMore = vyhledNaMore;
    }

    public int getCislo() {
        return cislo;
    }
    public int getPocetLuzek() {
        return pocetLuzek;
    }
    public double getCena() {
        return cena;
    }
    public boolean hasBalkon() {
        return balkon;
    }
    public boolean hasVyhledNaMore() {
        return vyhledNaMore;
    }

    @Override
    public String toString() {

        //Použití StringBuilder pro efektivní modifikací a úpravu řetezců bez vytváření nových instancí
        StringBuilder popis = new StringBuilder("Pokoj číslo " + cislo + " je");

        if (pocetLuzek == 1) {
            popis.append(" jednolůžkový");
        } else if (pocetLuzek == 2){
            popis.append(" dvojlůžkový");
        } else if (pocetLuzek == 3){
            popis.append(" trojlůžkový");
        } else {
            popis.append(" pokoj s ").append(pocetLuzek).append(" lůžky");
        }

        popis.append(" za cenu ").append(cena).append(" Kč/noc,");

        if (balkon) {
            popis.append(" s balkónem");
        } else {
            popis.append(" bez balkónu");
        }

        if (vyhledNaMore) {
            popis.append(", s výhledem na moře.");
        } else {
            popis.append(", bez výhledu na moře.");
        }

        return popis.toString();
    }
}
