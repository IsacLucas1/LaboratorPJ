package Problema2;

/**
 * Clasa PerecheNumere: 2 param.: int a si int b
 *
 * @author Isac Lucas-Horatiu
 * @version 1
 * @since 2024-11-14
 */
public class PerecheNumere {
    private int a,b;

    public PerecheNumere() {
    }

    /**Constructor cu parametrii
     *
     * @param a
     * @param b
     */
    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" + "a=" + a + ", b=" + b + '}';
    }

    /**
     * Returneaza true daca a si b sunt termeni consecutivi in sirul lui FIbonacci
     *
     */
    public boolean Fibo()
    {
        int x = 0, y = 1, z=0;

        if(a<0||b<0)
            return false;

        if(x==a && y==b)
            return true;

        while(z<=a)
        {
            z = x + y;
            x=y;
            y=z;

            if (x==a && y==b)
                return true;
        }
        return false;
    }

    /**Returneaza cel mai mic multiplu comun al numerelor a si b
     *
     */
    public int cmmmc()
    {
        int x=a,y=b;
        if(a<0)
            x*=-1;
        if(b<0)
            y*=-1;
        if(x==0 || y==0)
            return 0;
        while(x!=y)
        {
            if(x<y)
                x=x+a;
            if(x>y)
                y=y+b;
        }
        return x;
    }

    /**Returneaza true daca suma cifrelor celor doua numere este egala
     *
     */
    public boolean sumaCifre()
    {
        int s_a=0,s_b=0, x=a,y=b;
        while(x>0)
        {
            s_a += x%10;
            x=x/10;
        }
        while(y>0)
        {
            s_b += y%10;
            y=y/10;
        }
        return s_a==s_b;
    }

    /**Returneaza true daca cele doua numere au acelasi numar de cifre pare
     *
     */
    public boolean cifPare()
    {
        int x=a,y=b, ak=0, bk=0;
        while(x>0)
        {
            if((x%10)%2==0)
                ak++;
            x=x/10;
        }
        while(y>0)
        {
            if((y%10)%2==0)
                bk++;
            y=y/10;
        }
        return ak==bk;
    }

}
