package Laborator6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp {

    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file=new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Angajat> citire() {
        try {
            File file=new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Angajat> angajat = mapper.readValue(file, new TypeReference<List<Angajat>>(){});
            return angajat;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void afisare_filtrata(List<Angajat> ang, Predicate<Angajat> f) {
        for(Angajat a:ang)
            if(f.test(a))
                System.out.println(a);
    }

    public static void main(String[] args){

        List<Angajat> ang = citire();

        // Exercitiul 1
        ang.forEach(System.out::println);
        System.out.println("\n\n");

        // Exrcitiul 2
        System.out.println("Angajatii cu salariu mai mare decat 2500RON: ");
//        afisare_filtrata(ang, new Predicate<Angajat>() {
//            @Override
//            public boolean test(Angajat ang) {
//                return ang.getSalariul()>2500;
//            }
//        });
        afisare_filtrata(ang, a->a.getSalariul()>2500);
        System.out.println("\n\n");

        // Exercitiul 3
        List<Angajat> ang2 = ang
                .stream()
                .filter((angajat) -> angajat.getData_angajarii().getYear() == LocalDate.now().getYear() -1 &&
                        (angajat.getPostul().contains("sef")||angajat.getPostul().contains("director")))
                .collect(Collectors.toList());
        System.out.println("Angajati din aprilie care sunt sefi sau directori: ");
        ang2.forEach(System.out::println);
        System.out.println("\n\n");

        // Exercitiul 4
        List<Angajat> ang3 = ang
                .stream()
                .filter((angajat) -> !(angajat.getPostul().contains("sef")||angajat.getPostul().contains("director")))
                .sorted((a,b)->Float.valueOf(b.getSalariul()).compareTo(Float.valueOf(a.getSalariul())))
                .collect(Collectors.toList());
        System.out.println("Angajati care nu sunt sefi sau directori in ordide desc a salariului: ");
        ang3.forEach(System.out::println);
        System.out.println("\n\n");

        // Exercitiul 5
        List<String> ang4 = ang
                .stream()
                .map(Angajat::getNumele)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Numele angajatilor cu majuscule: ");
        ang4.forEach(System.out::println);
        System.out.println("\n\n");

        // Exercitiul 6
        List<Float> ang5 = ang
                .stream()
                .map(Angajat::getSalariul)
                .filter((a) -> a<3000)
                .collect(Collectors.toList());
        System.out.println("Salarii mai mici de 3000RON: ");
        ang5.forEach(System.out::println);
        System.out.println("\n\n");

        // Exercitiul 7
        Optional<Angajat> ang6 = ang
                .stream()
                .min(Comparator.comparing(Angajat::getData_angajarii));
        System.out.println("Primul angajat: ");
        ang6.ifPresentOrElse(System.out::println, () -> System.out.println("Nu exista angajati"));
        System.out.println("\n\n");

        // Exercitiul 8
        DoubleSummaryStatistics ang7 = ang
                .stream()
                .map(Angajat::getSalariul)
                .collect(Collectors.summarizingDouble(Float::doubleValue));
        System.out.println("Salariu minim: "+ ang7.getMin());
        System.out.println("Salariu maxim: "+ ang7.getMax());
        System.out.println("Salariu mediu: "+ ang7.getAverage());
        System.out.println("\n\n");

        // Exercitiul 9
        Optional<Angajat> ang8 = ang
                .stream()
                .filter(angajat -> "Ion".equals(angajat.getNumele()))
                .findAny();
        ang8.ifPresentOrElse(angajat -> System.out.println("Firma are cel putin un Ion angajat"), ()-> System.out.println("Firma nu are nici un Ion angajat"));
        System.out.println("\n\n");

        // Exercitiul 10
        long ang9 = ang
                .stream()
                .filter(angajat -> angajat.getData_angajarii().getYear() == LocalDate.now().getYear() - 1)
                .filter(angajat -> {
                    int luna = angajat.getData_angajarii().getMonthValue();
                    return luna >= 6 && luna <= 8;
                })
                .count();
        System.out.println("Numarul de persoane angajate vara trecuta: "+ ang9);
    }
}
