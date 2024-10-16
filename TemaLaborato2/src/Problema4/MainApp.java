//4. Să se realizeze un program care citește numele si CNP-ul pe care îl au n persoane.
//Valoarea lui n se citește de la tastatură. Programul va afișa informațiile introduse și în plus
//pentru fiecare persoana va afișa vârsta. Cât timp un CNP-ul este introdus greșit programul va
//cere reintroducerea acestuia. Pentru simplitate se consideră că CNP-ul este valid dacă
//îndeplinește următoarele condiții:
//        • Are 13 caractere
//        • Toate caracterele sunt cifre
//        • Prima cifră are una din valorile 1, 2, 5, 6
//        • Cifra de control a CNP-ului are o valoare validă.
//   Detalii legate de semnificația cifrelor din codul numeric personal şi de modul de calcul al
//cifrei de control se găsesc pe link-ul:
//https://www.scientia.ro/stiinta-la-minut/128-cultura-economie/459-cnp-codulnumeric-personal.html
//   Se va crea clasa Persoana cu variabile membre private nume (String) şi cnp (String).
//Clasa va avea constructor cu parametri, gettere si settere în funcție de necesități şi metoda
//getVarsta() care va calcula şi va returna vârsta persoanei extrăgând data nașterii din CNP şi
//citind din sistem data curentă. Se va utiliza clasa LocalDate. Se va crea un vector în care se
//vor adăuga obiectele de tip Persoana. Fiecare element din vectorul va fi afișat pe un rând în
//formatul nume, CNP, varsta.

package Problema4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainApp {
    private static int verifCnp(String cnp)
    {
        String control = "279146358279";
        int suma=0;
        if(cnp.length()!=13)
        {
            return 0;
        }
        if(cnp.charAt(0)!='1' && cnp.charAt(0)!='2' && cnp.charAt(0)!='5' && cnp.charAt(0)!='6')
        {
            return 0;
        }
        for(int i=0; i<13; i++)
        {
            if(cnp.charAt(i)<'0' || cnp.charAt(i)>'9')
            {
                return 0;
            }
        }
        for(int i=0; i<=11; i++) {
            int a = cnp.charAt(i) - 48;
            int b = control.charAt(i) - 48;
            suma = suma + a * b;
        }
        int c = suma/11;
        char cont = (char)(suma-c*11 + 48);
        if(cnp.charAt(12)!=cont)
        {
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        String nume="", cnp="";
        System.out.print("Numar de persoane:");
        n = scanner.nextInt();
        String nimic= scanner.nextLine();
        Persoana[] pers = new Persoana[n];
        for(int i=0; i<n;i++)
        {
            System.out.print("Introduceti numele: ");
            nume += scanner.nextLine();
            int ok=0;
            while(ok==0) {
                System.out.print("Introduceti CNP-ul: ");
                cnp = scanner.nextLine();
                ok = verifCnp(cnp);
            }
            Persoana p = new Persoana(nume, cnp);
            pers[i] = p;
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(pers[i]+"\nVarsta: "+pers[i].getVarsta());
        }
    }
}
