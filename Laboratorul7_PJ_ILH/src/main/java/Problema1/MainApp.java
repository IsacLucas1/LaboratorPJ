package Problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MainApp {

    public static void scriere(Map<Integer, Carte> map) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Carte> citire() {
        try {
            File file=new File("src/main/resources/carti.json");
            ObjectMapper mapper=new ObjectMapper();
            Map<Integer, Carte> map = mapper
                    .readValue(file, new TypeReference<Map<Integer,Carte>>(){});
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //Carte carte = new Carte("a", "a", 1900);
        Map<Integer,Carte> map= new HashMap<Integer,Carte>();
        map = citire();

        Set<Map.Entry<Integer, Carte>> set = null;

        int opt;

        Scanner sc = new Scanner(System.in);


        while(true)
        {
            System.out.println(
                    "1) Să se afișeze colecția (se vor afișa atât cheile cât şi valorile, utilizând inferenţa tipului\n" +
                            "                    pentru variabilele locale).\n" +
                            "                    2) Să se șteargă o carte din colecția Map\n" +
                            "                    3) Să se adauge o carte la colecția Map (se va utiliza metoda putIfAbsent)\n" +
                            "                    4) Sa se salveze în fișierul JSON modificările făcute asupra colecției\n" +
                            "                    5) Să se creeze o colecție Set<Carte> care extrage din colecția Map cărțile autorului\n" +
                            "                    Yual Noah Harari. Se va utiliza Stream API şi colectori. Se va afișa colecția creată cu\n" +
                            "                    ajutorul metodei forEach.\n" +
                            "                    6) Să se afișeze ordonat după titlul cărți elementele din colecția Set folosind Stream API,\n" +
                            "                    expresii Lambda şi referințe la metode.\n" +
                            "                    7) Să se afișeze datele celei mai vechi cărți din colecția Set folosind Stream API şi clasa\n" +
                            "                    Optional");
            System.out.println("Optiunea dvs.: ");
            opt = sc.nextInt();
            var entryset=map.entrySet();
            var it=entryset.iterator();

            switch (opt)
            {
                case 0:
                    System.exit(0);
                case 1:
                    entryset = map.entrySet();
                    it = entryset.iterator();
                    while(it.hasNext())
                    {
                        var m =it.next();
                        String key = String.valueOf(m.getKey());
                        Carte value = m.getValue();
                        System.out.println("Cheie: "+key+" Valaore: "+value.toString());
                    }
                    break;
                case 2:
                    System.out.println("Introduceti cheia cartii de sters");
                    int cheie;
                    cheie = sc.nextInt();
                    map.remove(cheie);
                    break;
                case 3:
                    int c, an;
                    String titlu, autor;
                    System.out.println("Cheie: ");
                    c = sc.nextInt();
                    System.out.println("Titlu: ");
                    titlu = sc.next();
                    System.out.println("Autor: ");
                    autor = sc.next();
                    System.out.println("An: ");
                    an = sc.nextInt();

                    map.putIfAbsent(c,new Carte(titlu, autor, an));
                    break;
                case 4:
                    scriere(map);
                    break;
                case 5:
                    set = map
                            .entrySet()
                            .stream()
                            .filter((a) -> a.getValue().autorul().equals("Yuval Noah Harari"))
                            .collect(Collectors.toSet());
                    set.forEach(System.out::println);
                    break;
                case 6:
                    if (set != null) {
                        set
                                .stream()
                                .sorted((a, b) -> a.getValue().titlul().compareTo(b.getValue().titlul()))
                                .forEach(System.out::println);
                    }
                    break;
                case 7:
                    if (set != null) {
                        Optional<Map.Entry<Integer, Carte>> ceaMaiVecheCarte = set
                                .stream()
                                .min(Comparator.comparingInt((a) -> a.getValue().anul()));

                        System.out.println("\nCea mai veche carte scrisa de Yuval Noah Harari:");
                        System.out.println("Cheie: " + ceaMaiVecheCarte.get().getKey()
                                + ", Valoare: " + ceaMaiVecheCarte.get().getValue());
                    }
                    break;
                default:
                    System.out.println("Optiune gresita");
                    break;
            }
        }

    }
}
