package Uke35;

import java.util.Arrays;
import java.util.Random;

public class Tabell {
    private Tabell() {}

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }// privat standardkonstruktør - hindrer instansiering
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }public static int maks(int[] a, int fra, int til)
    {
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }


    public static void bytt(char[]c, int i , int j){
        //Den skal bytte posisjon i og j char-tabllen c
        char temp= c[i]; c[i]=c[j]; c[j]=temp;
    }


    public static void fratilKontroll(int tablengde, int fra, int til)
            //fratilKontroll metode
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }
    public static void skriv(char[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);
        if (til - fra > 0) System.out.print(a[fra]);
        for (int i = fra + 1; i < til; i++) System.out.print(" " + a[i]);
    }
    public static void skriv(char[] a)
    {
        skriv(a, 0, a.length);
    }

    public static void skrivln(char[] a, int fra, int til)
    {
        skriv(a,fra,til);
        System.out.println();
    }

    public static void skrivln(char[] a)
    {
        skrivln(a, 0, a.length);
    }
    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a, 1, n);                  // leter i a[1:n>
        }
        else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = maks(a, 0, n - 1);              // leter i a[0:n-1>
        }
        else
        {
            int mv = maks(a, 0, m);              // leter i a[0:m>
            int mh = maks(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks




    // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)

    // Metoden randPerm(int n)                   Programkode 1.1.8 e)
    // Metoden randPerm(int[] a)                 Programkode 1.1.8 f)

    // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)
    // Metoden maks(int[] a)                     Programkode 1.2.1 c)

    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1
    Tabell tabell = new Tabell();


}

