package Problema2;

import java.util.Random;

public class Vers {
    private String vers;
    public Vers() {
    }
    public Vers(String vers)
    {
        this.vers = vers;
    }
    public String getVers()
    {
        return vers;
    }
    public void setVers(String vers)
    {
        this.vers = vers;
    }
    public void printVers()
    {
        System.out.println(vers);
    }
    public int getNrCuvinte()
    {
        String[] words = vers.split("[ ,-]");
        return words.length;
    }
    public int getNrVocale()
    {
        int nrVocale = 0;
        for (int i = 0; i < vers.length(); i++) {
            char c = vers.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                nrVocale++;
        }
        return nrVocale;
    }
    public boolean putStar(String grupareAleasa)
    {
        int lungimeVers = vers.length();
        if (vers.charAt(lungimeVers - 1) == ',' || vers.charAt(lungimeVers - 1) == '!'
                || vers.charAt(lungimeVers - 1) == '?' || vers.charAt(lungimeVers - 1) == '.')
        {
            lungimeVers--;
        }
        if (vers.substring(lungimeVers - grupareAleasa.length(), lungimeVers).equalsIgnoreCase(grupareAleasa))
        {
            return true;
        }
        return false;
    }
    public void randomGen()
    {
        float nrRandom = new Random().nextFloat(1);
        String upperCase = vers.toUpperCase();
        if (nrRandom < 0.1) {
            setVers(upperCase);
        }
    }
}
