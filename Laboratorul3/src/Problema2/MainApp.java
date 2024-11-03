package Problema2;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    static Scanner sc = new Scanner(System.in);

    public static void adLista(List<Produs> listaProduse) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BufferedReader br = new BufferedReader(new FileReader("produse.csv"));
        String linie;

        while((linie = br.readLine())!=null)
        {
            String [] parametrii = linie.split(",");
            listaProduse.add(new Produs(parametrii[0], Float.parseFloat(parametrii[1]), Integer.parseInt(parametrii[2]), LocalDate.parse(parametrii[3], dtf)));
        }
    }

    public static void afisareProduse(List<Produs> listaProduse) {
        for (Produs produs : listaProduse)
            System.out.println(produs.toString());
    }

    public static void afisareProduseExpirate(List<Produs> listaProduse) {
        LocalDate azi = LocalDate.now();
        for (Produs produs : listaProduse)
        {
            if(azi.isAfter(produs.getDataExpirarii()))
                System.out.println(produs.toString());
        }
    }

    public static void vanzareProd(List<Produs> listaProduse)
    {
        String numeProdus;
        int cantitVand;

        System.out.println("Nume produs de vandut: ");
        numeProdus = sc.next();
        System.out.println("Cantitate: ");
        cantitVand = sc.nextInt();

        for(Produs produs : listaProduse)
        {
            if(produs.getDenumire().equals(numeProdus))
            {
                produs.vanzari(cantitVand);
                System.out.println(produs + " " + Produs.getIncasari());
                if(produs.getCantitate()==0)
                {
                    listaProduse.remove(produs);
                }
                break;
            }
        }
    }

    public static void afisareProdusePretMin(List<Produs> listaProduse)
    {
        float minim = Float.MAX_VALUE;
        for (Produs produs : listaProduse)
        {
            if(produs.getPret()<minim)
                minim = produs.getPret();
        }

        for (Produs produs : listaProduse)
        {
            if(produs.getPret()==minim)
                System.out.println(produs);
        }
    }

    public static void salvFisier(List<Produs> listaProduse) throws FileNotFoundException {
        PrintStream ps = new PrintStream("produse_out.txt");

        int cantit;
        System.out.println("Cantitate: ");
        cantit = sc.nextInt();
        for(Produs produs : listaProduse)
        {
            if (produs.getCantitate() < cantit)
            {
                ps.println(produs.toString());
            }
        }
        ps.close();
    }

    public static void main(String[] args) throws IOException {
        List<Produs> listaProduse= new ArrayList<Produs>();
        adLista(listaProduse);

        int opt;

        while(true)
        {
            System.out.println("1) Afisarea produselor");
            System.out.println("2) Afisarea produselor expirate");
            System.out.println("3) Vanzarea unui produs");
            System.out.println("4) Afisarea produselor care au pretul minim");
            System.out.println("5) Salvare in fisier");
            System.out.println("0) Exit");
            opt = sc.nextInt();

            switch (opt)
            {
                case 0: System.exit(0);
                case 1:
                    System.out.println("\n\nLista Produselor: ");
                    afisareProduse(listaProduse);
                    break;
                case 2:
                    System.out.println("\n\nProduse expirate:");
                    afisareProduseExpirate(listaProduse);
                    break;
                case 3:
                    System.out.println("\n\nVanzare");
                    vanzareProd(listaProduse);
                    break;
                case 4:
                    System.out.println("\n\nProdusele cu pret minim: ");
                    afisareProdusePretMin(listaProduse);
                    break;
                case 5:
                    System.out.println("\n\nSalvare in fisier a produselor cu o cantitate mai mica");
                    salvFisier(listaProduse);
                    break;
                default:
                    System.out.println("Optiunea dumneavoastra nu exista");
                    break;
            }
        }
    }
}
