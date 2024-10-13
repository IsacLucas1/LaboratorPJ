package Problema4;

import java.time.LocalDate;

public class Persoana
{
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp)
    {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume()
    {
        return nume;
    }

    public String getCnp()
    {
        return cnp;
    }

    public int getVarsta()
    {
        LocalDate ld = LocalDate.now();
        int an = ld.getYear();
        int luna = ld.getMonthValue();
        int zi = ld.getDayOfMonth();
        int an_pers, luna_pers, zi_pers;
        if(this.cnp.charAt(0)<=2)
        {
            an_pers=1900+(this.cnp.charAt(1)-'0')*10+this.cnp.charAt(2)-'0';
        }
        else
        {
            an_pers=2000+(this.cnp.charAt(1)-'0')*10+this.cnp.charAt(2)-'0';
        }
        luna_pers=(this.cnp.charAt(3)-'0')*10+this.cnp.charAt(4)-'0';
        zi_pers=(this.cnp.charAt(5)-'0')*10+this.cnp.charAt(6)-'0';
        int varsta=0;
        if(luna_pers<luna)
        {
            varsta = an - an_pers;
        }
        else if(luna_pers == luna)
        {
            if (zi_pers < zi)
            {
                varsta = an - an_pers;
            }
            else
            {
                varsta = an - an_pers + 1;
            }
        }
        else
        {
            varsta = an - an_pers + 1;
        }
        return varsta;
    }
    public String toString()
    {
        return "Nume: " + this.nume + "\nCNP: " + this.cnp;
    }
}
