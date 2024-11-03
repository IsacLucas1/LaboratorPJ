package Problema2;

import java.time.LocalDate;

public class Produs {
    private String denumire;
    private float pret;
    private int cantitate;
    private LocalDate dataExpirarii;
    private static float incasari = 0;

    public Produs(String denumire, float pret, int cantitate, LocalDate dataExpirarii)
    {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirarii = dataExpirarii;
    }

    public void setDenumire(String denumire)
    {
        this.denumire = denumire;
    }
    public String getDenumire() {
        return denumire;
    }

    public void setCantitate(int cantitate)
    {
        this.cantitate = cantitate;
    }
    public int getCantitate()
    {
        return cantitate;
    }

    public void setPret(float pret)
    {
        this.pret = pret;
    }
    public float getPret() {
        return pret;
    }

    public void setDataExpirarii(LocalDate dataExpirarii)
    {
        this.dataExpirarii = dataExpirarii;
    }
    public LocalDate getDataExpirarii()
    {
        return dataExpirarii;
    }

    public static float getIncasari()
    {
        return incasari;
    }

    @Override
    public String toString() {
        return denumire  + "\t" +  pret + "\t" + cantitate + "\t"+ dataExpirarii;
    }

    public void vanzari(int cantitateVand)
    {
        if(cantitateVand <= cantitate)
        {
            incasari += pret * cantitateVand;
            cantitate -= cantitateVand;
        }
    }

}
