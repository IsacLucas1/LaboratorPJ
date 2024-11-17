package Problema3;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa Mobilier este folosita pentru stocarea datelor din fisierul mobilier.json
 */
public class Mobilier{
    private String nume;
    private List<Placa> placi = new ArrayList<>();

    public Mobilier(){}

    public Mobilier(String nume, List<Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }
    public void setPlaca(List<Placa> placi) {
        this.placi = placi;
    }

    @Override
    public String toString() {
        return nume + " " + placi.toString();
    }

    /**
     * Functie pentru numarul de coli de pal necesare pentru a realiza toate placile din componenta unei mobile
     * @return nr de coli
     */
    public int nrColiPal()
    {
        int arie = 0;
        for(Placa p: placi)
        {
            arie += p.arieTotala();
        }
        if(arie % (2800*2070)!=0)
            return arie/(2800*2070)+1;
        else
            return arie/(2800*2070);
    }
}
