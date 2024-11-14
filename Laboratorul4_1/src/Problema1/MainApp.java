package Problema1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainApp {

    public static void serializare(Object o, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserializare(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        List<Echipament> echip = new ArrayList<Echipament>();
        BufferedReader br = new BufferedReader(new FileReader("echipamente.txt"));
        String linie;
        int nr_inv;
        int opt;
        Scanner sc = new Scanner(System.in);

        while((linie = br.readLine())!=null)
        {
            String [] elem = linie.split(";");

            if(elem[5].equals("imprimanta"))
            {
                echip.add(new Imprimante(elem[0], Integer.parseInt(elem[1]),
                        Integer.parseInt(elem[2]), elem[3], Situatie.valueOf(elem[4]),
                        elem[5], Integer.parseInt(elem[6]), elem[7], Integer.parseInt(elem[8]),
                        Tiparire.valueOf(elem[9])));
            }
            else if(elem[5].equals("copiator"))
            {
                echip.add(new Copiatoare(elem[0], Integer.parseInt(elem[1]),
                        Integer.parseInt(elem[2]), elem[3], Situatie.valueOf(elem[4]),
                        elem[5], Integer.parseInt(elem[6]), Format.valueOf(elem[7])));
            }
            else if(elem[5].equals("sistem de calcul"))
            {
                echip.add(new Sisteme(elem[0], Integer.parseInt(elem[1]),
                        Integer.parseInt(elem[2]), elem[3], Situatie.valueOf(elem[4]),
                        elem[5], elem[6], Float.parseFloat(elem[7]), Integer.parseInt(elem[8]),
                        OperSist.valueOf(elem[9])));
            }
        }
        while(true) {
            System.out.println("1) Afişarea tuturor echipamentelor\n" +
                    "• 2) Afişarea imprimantelor\n" +
                    "• 3) Afişarea copiatoarelor\n" +
                    "• 4) Afişarea sistemelor de calcul\n" +
                    "• 5) Modificarea stării în care se află un echipament\n" +
                    "• 6) Setarea unui anumit mod de scriere pentru o imprimantă\n" +
                    "• 7) Setarea unui format de copiere pentru copiatoare\n" +
                    "• 8) Instalarea unui anumit sistem de operare pe un sistem de calcul\n" +
                    "• 9) Afişarea echipamentelor vândute\n" +
                    "• 10) Să se realizeze două metode statice pentru serializarea / deserializarea colecției de\n" +
                    "obiecte în fișierul echip.bin ");
            System.out.println("Optiunea dumneavoastra: ");
            opt = sc.nextInt();
            switch (opt) {
                case 0:
                    System.exit(0);
                case 1:
                    for (Echipament e : echip) {
                        System.out.println(e);
                    }
                    System.out.println("\n\n");
                    break;
                case 2:
                    for (Echipament e : echip) {
                        if (e.getTipEchip().equals("imprimanta")) {
                            System.out.println(e);
                        }
                    }
                    System.out.println("\n\n");
                    break;
                case 3:
                    for (Echipament e : echip) {
                        if (e.getTipEchip().equals("copiator")) {
                            System.out.println(e);
                        }
                    }
                    System.out.println("\n\n");
                    break;
                case 4:
                    for (Echipament e : echip) {
                        if (e.getTipEchip().equals("sistem de calcul")) {
                            System.out.println(e);
                        }
                    }
                    System.out.println("\n\n");
                    break;
                case 5:
                    System.out.print("Numarul de inventar al echipamentului: ");
                    nr_inv = sc.nextInt();

                    System.out.print("Noua stare a echipamentului: ");
                    String sit = sc.next();

                    for (Echipament e : echip) {
                        if (e.getNr_inv() == nr_inv) {
                            if (sit.equals("achizitionat") || sit.equals("expus") || sit.equals("vandut")) {
                                e.setSit(Situatie.valueOf(sit));
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.print("Numarul de inventar al imprimantei: ");
                    nr_inv = sc.nextInt();

                    System.out.print("Noul mod de scriere al imprimantei: ");
                    String mod = sc.next();

                    for (Echipament e : echip) {
                        if (e.getNr_inv() == nr_inv && e.getTipEchip().equals("imprimanta")) {
                            if (mod.equals("color") || mod.equals("alb_negru")) {
                                e.setEnum(Tiparire.valueOf(mod));
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.print("Numarul de inventar al copiatorului:  ");
                    nr_inv = sc.nextInt();

                    System.out.print("Noul format de copiere al copiatorului: ");
                    String format = sc.next();

                    for (Echipament e : echip) {
                        if (e.getNr_inv() == nr_inv && e.getTipEchip().equals("copiator")) {
                            if (format.equals("A3") || format.equals("A4")) {
                                e.setEnum(Format.valueOf(format));
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.print("Numarul de inventar al sistemului de calcul: ");
                    nr_inv = sc.nextInt();

                    System.out.print("Noul sistem de operare: ");
                    String operSist = sc.next();

                    for (Echipament e : echip) {
                        if (e.getNr_inv() == nr_inv && e.getTipEchip().equals("sistem de calcul")) {
                            if (operSist.equals("windows") || operSist.equals("linux")) {
                                e.setEnum(OperSist.valueOf(operSist));
                            }
                        }
                    }
                    break;
                case 9:
                    for (Echipament e : echip) {
                        if (e.getSit().equals(Situatie.vandut)) {
                            System.out.println(e);
                        }
                    }
                    System.out.println("\n\n");
                    break;
                case 10:
                    int opt1;
                    System.out.println("1) Serializare\n2)Deserializare\n0)Meniu Principal\nOptiunea dumneavoastra: ");
                    opt1 = sc.nextInt();
                    switch (opt1) {
                        case 1:
                            serializare(echip, "echip.bin");
                            break;
                        case 2:
                            List<Echipament> q = (List<Echipament>) deserializare("echip.bin");
                            for (Echipament e : q) {
                                System.out.println(e);
                            }
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Optiune gresita");
                    }
                    break;
            default:
                System.out.println("Optiune gresita!");
                break;
                }
        }
    }
}
