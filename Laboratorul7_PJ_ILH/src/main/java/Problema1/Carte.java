package Problema1;

public record Carte(String titlul, String autorul, int anul) {
    @Override
    public String toString() {
        return  titlul + " " + " " + autorul + " " + anul;
    }
}

