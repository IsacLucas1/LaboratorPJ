package Problema1;

public class Parabola {
    private int a;
    private int b;
    private int c;

    public Parabola() {}

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }

    public Punct coordVarf()
    {
        return new Punct(((float)(-(b/2*a))), (float)((-(b*b)+4*a*c)/4*a));
    }

    @Override
    public String toString() {
        return "f(x)= " + a + "x^2 + " + b + "x + "+ c;
    }

    public Punct coordMijl1(Parabola p)
    {
        Punct p0 = coordVarf();
        Punct p1 = p.coordVarf();

        float x, y;

        x = (p0.getX() + p1.getX())/2;
        y = (p0.getY() + p1.getY())/2;

        return new Punct(x, y);
    }

    public static Punct coordMijl2(Parabola p1, Parabola p2)
    {
        Punct par1 = p1.coordVarf();
        Punct par2 = p2.coordVarf();

        float x, y;

        x = (par1.getX() + par2.getX())/2;
        y = (par1.getY() + par2.getY())/2;

        return new Punct(x, y);
    }

    public double lung1(Parabola p)
    {
        Punct p0 = coordVarf();
        Punct p1 = p.coordVarf();

        return Math.hypot((p0.getX() - p1.getX()), (p0.getY() - p1.getY()));
    }

    public static double lung1(Parabola p1, Parabola p2)
    {
        Punct par1 = p1.coordVarf();
        Punct par2 = p2.coordVarf();

        return Math.hypot((par1.getX() - par2.getX()), (par1.getY() - par2.getY()));
    }

}
