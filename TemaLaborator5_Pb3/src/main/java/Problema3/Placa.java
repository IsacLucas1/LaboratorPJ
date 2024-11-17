package Problema3;

import java.util.Arrays;

/**
 * Clasa Placa este folosita pentru a contine detaliile placilor din componenta unui corp de mobilier
 */
public class Placa {
    private String descriere;
    private int lungime;
    private int latime;
    private boolean [] canturi = new boolean[4];
    private int nr_bucati;
    private Orientare orientare;

    public Placa(){}

    public Placa(String descriere, int lungime, int latime, boolean[] canturi, int nr_bucati, Orientare orientare) {
        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.canturi = canturi;
        this.nr_bucati = nr_bucati;
        this.orientare = orientare;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getLungime() {
        return lungime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public int getLatime() {
        return latime;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    public boolean[] getCanturi() {
        return canturi;
    }

    public void setCanturi(boolean[] canturi) {
        this.canturi = canturi;
    }

    public int getNr_bucati() {
        return nr_bucati;
    }

    public void setNr_bucati(int nr_bucati) {
        this.nr_bucati = nr_bucati;
    }

    public Orientare getOrientare() {
        return orientare;
    }

    public void setOrientare(Orientare orientare) {
        this.orientare = orientare;
    }

    @Override
    public String toString() {
        return descriere + " " + " " + lungime + " " + latime + " " + Arrays.toString(canturi) + " " + nr_bucati + " " + orientare;
    }

    /**
     * @return Aria totala a tuturor placilor in total - int
     */
    public int arieTotala()
    {
        return lungime * latime * nr_bucati;
    }
}
