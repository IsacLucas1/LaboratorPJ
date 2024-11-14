package Problema1;

import java.io.Serializable;

public class Sisteme extends Echipament implements Serializable {
    private String tip_mon;
    private float vit_proc;
    private int c_hdd;
    private OperSist sist;

    public Sisteme() {}

    public Sisteme(String denumire, int nr_inv, int pret, String zona, Situatie sit, String tipEchip, String tip_mon, float vit_proc, int c_hdd, OperSist sist) {
        super(denumire, nr_inv, pret, zona,sit, tipEchip);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sist = sist;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }
    public String getTip_mon() {
        return tip_mon;
    }

    public void setVit_proc(int vit_proc) {
        this.vit_proc = vit_proc;
    }
    public float getVit_proc() {
        return vit_proc;
    }

    public void setC_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }
    public int getC_hdd() {
        return c_hdd;
    }

    public void setSist(OperSist sist) {
        this.sist = sist;
    }
    public OperSist getSist() {
        return sist;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + tip_mon + ", " + vit_proc + ", " + c_hdd + ", " + sist;
    }

    @Override
    public <OperSist extends Enum<OperSist>> void setEnum(Enum<OperSist> sist) {
        this.sist = (Problema1.OperSist) sist;
    }
}
