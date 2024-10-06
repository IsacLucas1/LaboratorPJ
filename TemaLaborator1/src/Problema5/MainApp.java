package Problema5;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        Random random = new Random();
        int a=random.nextInt(19) +1;
        System.out.println("a="+a);
        int x=1, y=1, z=0, k=0;
        if(a==1)
        {
            System.out.println("Numarul apartine Sirului lui Fibonacci");
            k++;
        }
        else
        {
            while(z<a)
            {
                z=x+y;
                x=y;
                y=z;
                if(z==a)
                {
                    System.out.println("Numarul apartine Sirului lui Fibonacci");
                    k++;
                    break;
                }
            }
        }
        if(k==0)
        {
            System.out.println("Numarul nu apartine Sirului lui Fibonacci");
        }
    }
}
