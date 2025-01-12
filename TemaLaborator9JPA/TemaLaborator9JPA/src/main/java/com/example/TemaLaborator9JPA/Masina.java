package com.example.TemaLaborator9JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="masini")
public class Masina {

    @Id
    @Column(name = "nr_inmatriculare")
    private String nr_inmatriculare;
    private String marca;
    private int anul;
    private String culoare;
    private int numar_km;

    public Masina(){}
    public Masina(String nr_inmatricularem, String marca, int anul, String culoare, int numar_km){
        this.nr_inmatriculare = nr_inmatricularem;
        this.marca = marca;
        this.anul = anul;
        this.culoare = culoare;
        this.numar_km = numar_km;
    }

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }
    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnul() {
        return anul;
    }
    public void setAnul(int anul) {
        this.anul = anul;
    }

    public String getCuloare() {
        return culoare;
    }
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getNumar_km() {
        return numar_km;
    }
    public void setNumar_km(int numar_km) {
        this.numar_km = numar_km;
    }

    @Override
    public String toString() {
        return "Numar inmatriculare: " + nr_inmatriculare+", Marca: " + marca + ", An fabricatie: " + anul + ", Culoare: " + culoare + ", Nr Km: " + numar_km;
    }
}

