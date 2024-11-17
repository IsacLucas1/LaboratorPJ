package Problema2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    /**
     * Functie pentru scriere in fisierul numere.json
     * @param lista
     */
    public static void scriere_JSON(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/numere.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Functie pentru citire din fisierul numere.json
     * @return
     */
    public static List<PerecheNumere> citire_JSON() {
        try {
            File file=new File("src/main/resources/numere.json");
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> persoane = mapper
                    .readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<PerecheNumere> lista = new ArrayList<>();
//        lista = citire_JSON();
//        for(PerecheNumere p : lista)
//        {
//            System.out.println(p.toString());
//        }

        Scanner sc = new Scanner(System.in);
        int a, b, ok=1;
        while(ok!=0)
        {
            System.out.println("Adaugati numere");
            System.out.println("a= ");
            a = sc.nextInt();
            System.out.println("b= ");
            b = sc.nextInt();
            lista.add(new PerecheNumere(a,b));
            scriere_JSON(lista);
            System.out.println("Mai adaugati? (Da-orice nr diferit de 0   Nu-0)");
            ok = sc.nextInt();
        }
        System.out.println("Lista de perechi de numere: ");
        for(PerecheNumere p : lista)
        {
            System.out.println("\n\n");
            System.out.println(p.toString());
            System.out.print("Termeni consecutivi Fibonacci?    Rasp: ");
            System.out.println(p.Fibo());
            System.out.print("Cel mai mare multiplu comun: ");
            System.out.println(p.cmmmc());
            System.out.print("Au suma cifrelor egala?    Rasp: ");
            System.out.println(p.sumaCifre());
            System.out.print("Au acelasi numar de cifre pare?    Rasp: ");
            System.out.println(p.cifPare());
        }
        lista.clear();
        scriere_JSON(lista);
    }
}
