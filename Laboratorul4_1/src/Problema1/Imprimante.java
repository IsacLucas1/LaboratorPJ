package Problema1;

import java.io.Serializable;

public class Imprimante extends Echipament implements Serializable {
    private int ppm;
    private String rezolutie;
    private int p_car;
    private Tiparire tiparire;

    public Imprimante() {}

    public Imprimante(String denumire, int nr_inv, int pret, String zona, Situatie sit, String tipEchip, int ppm, String rezolutie, int p_car, Tiparire tiparire) {
        super(denumire, nr_inv, pret, zona, sit, tipEchip);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.tiparire = tiparire;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }
    public int getPpm() {
        return ppm;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }
    public String getRezolutie() {
        return rezolutie;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }
    public int getP_car() {
        return p_car;
    }

    public void setTiparire(Tiparire tiparire) {
        this.tiparire = tiparire;
    }
    public Tiparire getTiparire() {
        return tiparire;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + ppm + ", " + rezolutie + ", " + p_car + ", " + tiparire;
    }

    @Override
    public <Tiparire extends Enum<Tiparire>> void setEnum(Enum<Tiparire> tiparire) {
        this.tiparire = (Problema1.Tiparire) tiparire;
    }
}
