package Problema1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        List<Parabola> parabola = new ArrayList<Parabola>();

        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        String linie;

        while((linie = br.readLine())!=null)
        {
            String [] parametrii = new String [3];
            parametrii = linie.split(" ");

            parabola.add(new Parabola(Integer.parseInt(parametrii[0]), Integer.parseInt(parametrii[1]), Integer.parseInt(parametrii[2])));
        }

        System.out.println("Parabole: ");
        for(Parabola p : parabola)
        {
            System.out.println(p+ " , Cu varful de coordonate:" + p.coordVarf());
        }

        System.out.println("Mijlocul seg. dintre vf. p1 si vf. p2: " + parabola.get(0).coordMijl1(parabola.get(1)));
        System.out.println("Lungimea seg. dintre vf. p1 si vf. p2: " + parabola.get(0).lung1(parabola.get(1)));
    }
}
