package Laborator6;

import java.time.LocalDate;

public class Angajat {
    private String numele;
    private String postul;
    private LocalDate data_angajarii;
    private float salariul;

    public Angajat() {}

    public Angajat(LocalDate data_angajarii, String numele, String postul, float salariul) {
        this.data_angajarii = data_angajarii;
        this.numele = numele;
        this.postul = postul;
        this.salariul = salariul;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public void setNumele(String numele) {
        this.numele = numele;
    }

    public void setPostul(String postul) {
        this.postul = postul;
    }

    public void setSalariul(float salariul) {
        this.salariul = salariul;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public String getNumele() {
        return numele;
    }

    public String getPostul() {
        return postul;
    }

    public float getSalariul() {
        return salariul;
    }

    @Override
    public String toString() {
        return numele + ", " + postul + ", " + data_angajarii + ", " + salariul;
    }
}
