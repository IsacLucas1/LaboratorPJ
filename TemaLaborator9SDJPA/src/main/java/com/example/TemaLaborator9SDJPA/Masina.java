package com.example.TemaLaborator9SDJPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="masini3")
public class Masina {

    @Id
    @Column(name = "nrInmatriculare")
    private String nrInmatriculare;
    private String marca;
    private int anul;
    private String culoare;
    private int numarkm;

    public Masina(){}
    public Masina(String nrInmatriculare, String marca, int anul, String culoare, int numarkm){
        this.nrInmatriculare = nrInmatriculare;
        this.marca = marca;
        this.anul = anul;
        this.culoare = culoare;
        this.numarkm = numarkm;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
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

    public int getNumarkm() {
        return numarkm;
    }

    public void setNumarkm(int numarkm) {
        this.numarkm = numarkm;
    }

    @Override
    public String toString() {
        return "Numar inmatriculare: " + nrInmatriculare+", Marca: " + marca + ", An fabricatie: " + anul + ", Culoare: " + culoare + ", Nr Km: " + numarkm;
    }
}
