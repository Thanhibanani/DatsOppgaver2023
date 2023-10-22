package Uke34;

import java.util.NoSuchElementException;

public class Oppgave3 {
    public static void main(String[] args) {
        int [] a ={5,4,6,75,4,24,45,63};

        System.out.println(maks(a));
    }

    public static int maks(int[] a) // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        int m = 0; // indeks til foreløpig største verdi
        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i]>a[m]) m = i; // indeksen oppdateres
        }
        return m; // returnerer indeksen/posisjonen til minste verdi
    } // min
}
