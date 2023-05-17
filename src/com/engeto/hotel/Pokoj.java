package com.engeto.hotel;

public class Pokoj {
    private int cislo;
    private int cena;
    private boolean balkon;
    private boolean vyhledNaMore;
    public Pokoj(int cislo, int cena, boolean balkon, boolean vyhledNaMore) {
        this.cislo = cislo;
        this.cena = cena;
        this.balkon = balkon;
        this.vyhledNaMore = vyhledNaMore;
    }

    public int getCislo() {
        return cislo;
    }
    public int getCena() {
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
        String popis = "Pokoj číslo " + cislo + " je";
        if (cislo == 1 || cislo == 2) {
            popis += " jednolůžkový";
        } else {
            popis += " trojlůžkový";
        }
        popis += " za cenu " + cena + " Kč/noc,";
        if (balkon) {
            popis += " s balkónem";
        } else {
            popis += " bez balkónu";
        }
        if (vyhledNaMore) {
            popis += ", s výhledem na moře.";
        }
        return popis;
    }
}
