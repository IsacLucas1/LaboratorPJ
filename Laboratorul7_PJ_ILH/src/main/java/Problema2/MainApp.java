package Problema2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MainApp {
    public static void scriere(Set<InstrumentMuzical> set)
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file = new File("src/main/resources/instrumente.json");
            mapper.writeValue(file, set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<InstrumentMuzical> citire()
    {
        try {
            File file = new File("src/main/resources/instrumente.json");
            ObjectMapper mapper = new ObjectMapper();
            Set<InstrumentMuzical> set = mapper
                    .readValue(file, new TypeReference<Set<InstrumentMuzical>>() {
                    });
            return set;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //ex 1
        Set<InstrumentMuzical> instrumente = new HashSet<>();
        instrumente.add(new Chitara("Rathbone", 25000, TipChitara.ACUSTICA, 6));
        instrumente.add(new Chitara("Squier", 1500, TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("Hora", 2000, TipChitara.CLASICA, 7));
        instrumente.add(new SetTobe("Sonor", 3475, TipTobe.ACUSTICE, 5, 3));
        instrumente.add(new SetTobe("Ludwig", 4900, TipTobe.ELECTRONICE, 4, 2));
        instrumente.add(new SetTobe("Yamaha", 1800, TipTobe.ACUSTICE, 6, 4));
        System.out.println("\n\n");

        //ex2
        scriere(instrumente);

        //ex3
        Set<InstrumentMuzical> setInstrumente = new HashSet<>();
        setInstrumente = citire();

        //ex4
        System.out.println("Implementare utilizata: " + setInstrumente.getClass().getName());
        System.out.println("\n");
        System.out.println("Afisare instrumente:");
        System.out.println("\n");
        for (InstrumentMuzical instr : setInstrumente)
        {
            instr.descriereInstrument();
            System.out.println();
        }
        System.out.println("\n\n");

        //ex5
        Chitara c1 = new Chitara("Hora", 2000, TipChitara.CLASICA, 7);
        Chitara c2 = new Chitara("Hora", 2000, TipChitara.CLASICA, 7);
        if (c1.equals(c2))
        {
            System.out.println("Egale\n");
        }
        else
        {
            System.out.println("Diferite\n");
        }
        boolean exista = setInstrumente.add(c1);
        if (exista)
        {
            System.out.println("Instrumentul a fost adaugat!");
        }
        else
        {
            System.out.println("Instrumentul nu a fost adaugat!");
        }

        System.out.println("\n");

        SetTobe t1 = new SetTobe("Yamaha", 1800, TipTobe.ACUSTICE, 6, 4);
        SetTobe t2 = new SetTobe("Yamaha", 1800, TipTobe.ACUSTICE, 6, 4);

        if (t1.equals(t2))
        {
            System.out.println("Egale\n");
        }
        else
        {
            System.out.println("Diferite\n");
        }
        exista = setInstrumente.add(t1);
        if (exista)
        {
            System.out.println("Instrumentul a fost adaugat!");
        }
        else
        {
            System.out.println("Instrumentul nu a fost adaugat!");
        }
        System.out.println("\n");
        System.out.println("Afisare instrumente:\n");
        for (InstrumentMuzical instr : setInstrumente)
        {
            instr.descriereInstrument();
            System.out.println();
        }
        System.out.println("\n\n");

        //ex6
        setInstrumente.removeIf((a) -> a.getPret() > 3000);

        System.out.println("\nAfisare instrumente:\n");

        for (InstrumentMuzical instr : setInstrumente)
        {
            instr.descriereInstrument();
            System.out.println();
        }
        System.out.println("\n\n");

        //ex7
        setInstrumente.stream()
                .filter(instr -> instr instanceof Chitara)
                .map(instr -> (Chitara) instr)
                .forEach(System.out::println);
        System.out.println("\n\n");

        //ex8
        setInstrumente.stream()
                .filter(instr -> instr.getClass() == SetTobe.class)
                .map(instr -> (SetTobe) instr)
                .forEach(System.out::println);
        System.out.println("\n\n");

        //ex9
        Optional<Chitara> chitaraNrCorziMax = setInstrumente.stream()
                .filter(instr -> instr instanceof Chitara)
                .map(instr -> (Chitara) instr)
                .max((a, b) -> Integer.compare(a.getNr_corzi(), b.getNr_corzi()));

        chitaraNrCorziMax.ifPresentOrElse(
                chitara ->
                {
                    System.out.println("Chitara cu cele mai multe corzi este:");
                    chitara.descriereInstrument();
                },
                () -> System.out.println("Nu exista."));
        System.out.println("\n\n");

        //ex10
        setInstrumente.stream()
                .filter(instr -> instr instanceof SetTobe)
                .map(instr -> (SetTobe) instr)
                .filter(tobe -> tobe.getTip_tobe() == TipTobe.ACUSTICE)
                .sorted((a, b) -> Integer.compare(a.getNr_tobe(), b.getNr_tobe()))
                .forEach(SetTobe::descriereInstrument);
    }
}
