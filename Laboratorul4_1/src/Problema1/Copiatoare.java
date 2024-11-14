package Problema1;

import java.io.Serializable;

public class Copiatoare extends Echipament implements Serializable {
    private int p_ton;
    private Format form;

    public Copiatoare() {}

    public Copiatoare(String denumire, int nr_inv, int pret, String zona, Situatie sit, String tipEchip, int p_ton, Format form) {
        super(denumire, nr_inv, pret, zona, sit, tipEchip);
        this.p_ton = p_ton;
        this.form = form;
    }

    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }
    public int getP_ton() {
        return p_ton;
    }

    public void setForm(Format form) {
        this.form = form;
    }
    public Format getForm() {
        return form;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + p_ton + ", " + form;
    }

    @Override
    public <Format extends Enum<Format>> void setEnum(Enum<Format> form) {
        this.form = (Problema1.Format) form;
    }
}
