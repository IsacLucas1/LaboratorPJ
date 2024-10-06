package Problema3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("n=");
        int n=scanner.nextInt();
        for(int i=1;i<=n/2;i++)
        {
            if(n%i==0)
            {
                System.out.println(i);
            }
        }
        System.out.println(n);
    }
}
