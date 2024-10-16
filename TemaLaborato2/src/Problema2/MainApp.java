//2. Fișierul cantec_in.txt conține versurile unui cântec la alegere. Să se scrie un
//program care creează fișierul cantec_out.txt, care conține versurile cântecului original dar în
//plus în dreptul fiecărui rând sunt afișate numărul de cuvinte de pe rând şi numărul de vocale
//de pe fiecare rând. În dreptul rândurilor care se încheie cu o grupare de litere aleasă se va
//pune o steluță (*). Rândurile pentru care un număr generat aleator este mai mic decât 0.1 vor
//fi scrise cu majuscule (se vor genera aleator numere între 0 şi 1).
//   Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
//reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
//metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
//Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
//intrare.

package Problema2;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String fis_in = "cantec_in.txt", fis_out = "cantec_out.txt", linie = "";
        BufferedReader br_in = new BufferedReader(new FileReader(fis_in));
        PrintStream ps_out = new PrintStream(fis_out);
        String grupareAleasa;
        ArrayList<Vers> vs = new ArrayList<>();
        while (true)
        {
            linie = br_in.readLine();
            if (linie == null)
            {
                break;
            }
            vs.add(new Vers(linie));
        }
        System.out.print("Grupare aleasa: ");
        grupareAleasa = sc.nextLine();
        for (Vers v : vs)
        {
            boolean pStar = false;
            if (Objects.equals(v.getVers(), ""))
            {
                System.out.println();
                ps_out.println();
                continue;
            }
            pStar = v.putStar(grupareAleasa);
            v.randomGen();
            linie = v.getVers();
            linie = linie + " " + v.getNrCuvinte() + " " + v.getNrVocale() + " ";
            if (pStar == true)
            {
                linie += " *";
            }
            System.out.println(linie);
            ps_out.println(linie);
        }
    }
}

