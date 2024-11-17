package Problema3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clasa Principala
 * @author Isac Lucas-Horatiu
 * @version 1
 * @since 2024-11-17
 */
public class MainApp {

    /**
     * Functie pentru citire din fisierul mobilier.json
     * @return lista m
     */
    public static List<Mobilier> citire() {
        try {
            File file=new File("src/main/resources/mobilier.json");
            ObjectMapper mapper=new ObjectMapper();
            List<Mobilier> m = mapper
                    .readValue(file, new TypeReference<>(){});
            return m;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Mobilier> mobilier = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String numeMobila;
        int opt;
        while(true)
        {
            System.out.println("1) Citește datele despre piesele de mobilier din fișierul mobilier.json într-o listă de piese de mobilier (List<Mobilier>) și le afișează\n" +
                    "2) Afişează elementele de mobilier din colecție şi plăcile care le compun\n" +
                    "3) Afişează caracteristicile plăcilor care compun o anumită piesă de mobilier\n" +
                    "4) Afișează estimativ numărul colilor de pal necesare pentru realizarea unui anumit corp de mobile știind că o coală de pal are dimensiunea 2800 x 2070 mm (pentru simplitate\n" +
                    "se va ţine cont doar de arie, nu şi de posibilitatea de a realiza tăieturile\n" + "0)Iesire\n" +
                    "Optiunea dumneavoastra: ");
            opt = sc.nextInt();
            switch (opt)
            {
                case 0:
                    System.exit(0);
                case 1:
                    mobilier = citire();
                    assert mobilier != null;
                    for(Mobilier m: mobilier)
                    {
                        System.out.println(m.toString());
                    }
                    System.out.println("\n\n");
                    break;
                case 2:
                    mobilier = citire();
                    assert mobilier != null;
                    for(Mobilier m: mobilier)
                    {
                        System.out.println(m.getNume() + " ");
                        for(Placa p : m.getPlaci())
                        {
                            System.out.println(p.getDescriere());
                        }
                        System.out.println("\n");
                    }
                    System.out.println("\n\n");
                    break;
                case 3:
                    mobilier = citire();
                    assert mobilier != null;
                    System.out.println("Numele mobilei: ");
                    sc.nextLine();
                    numeMobila = sc.nextLine();
                    for(Mobilier m : mobilier)
                    {
                        if(m.getNume().equals(numeMobila))
                        {
                            System.out.println(m.toString());
                        }
                    }
                    break;
                case 4:
                    mobilier = citire();
                    assert mobilier != null;
                    System.out.println("Numele mobilei: ");
                    sc.nextLine();
                    numeMobila = sc.nextLine();
                    for(Mobilier m : mobilier)
                    {
                        if(m.getNume().equals(numeMobila))
                        {
                            System.out.println("Numarul de coli de pal este: " + m.nrColiPal());
                        }
                    }
                    break;
                default:
                    System.out.println("Optiune gresita!");
            }
        }
    }
}
