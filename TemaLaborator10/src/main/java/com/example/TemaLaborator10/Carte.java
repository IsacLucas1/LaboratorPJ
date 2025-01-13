package com.example.TemaLaborator10;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carti")
public class Carte {
    @Id
    private String isbn;
    private String titlul;
    private String autorul;

    public Carte() {}
    public Carte(String isbn, String titlul, String autorul) {
        this.isbn = isbn;
        this.titlul = titlul;
        this.autorul = autorul;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitlul() {
        return titlul;
    }
    public void setTitlul(String titlul) {
        this.titlul = titlul;
    }

    public String getAutorul() {
        return autorul;
    }
    public void setAutorul(String autorul) {
        this.autorul = autorul;
    }
}