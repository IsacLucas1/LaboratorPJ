package Problema1;

import java.io.Serializable;

public abstract class Echipament implements Serializable {
    private String denumire;
    private int nr_inv;
    private int pret;
    private String zona;
    private Situatie sit;
    private String tipEchip;

    public Echipament() {}

    public Echipament(String denumire, int nr_inv, int pret, String zona, Situatie sit, String tipEchip) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona = zona;
        this.tipEchip = tipEchip;
        this.sit = sit;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
    public String getDenumire() {
        return denumire;
    }

    public void setNr_inv(int nr_inv) {
        this.nr_inv = nr_inv;
    }
    public int getNr_inv() {
        return nr_inv;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
    public int getPret() {
        return pret;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    public String getZona() {
        return zona;
    }

    public void setSit(Situatie sit) {
        this.sit = sit;
    }
    public Situatie getSit() {
        return sit;
    }

    public String getTipEchip() {
        return tipEchip;
    }
    public void setTipEchip(String tipEchip) {
        this.tipEchip = tipEchip;
    }

    @Override
    public String toString() {
        return denumire + ", " + " " + nr_inv + ", " + pret + ", " + zona + ", " + tipEchip + ", " + sit;
    }

    public abstract <T extends Enum<T>> void setEnum(Enum<T> tEnum);
}
