package Uke34;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oppgave5 {
    public static void main(String[] args) {
        int[] a = {5, 4, 6, 75, 4, 24, 45, 63};

        System.out.println(Arrays.toString(minmaks(a)));
    }

    public static int[] minmaks(int[] a)
    {
        int mi = 0, minverdi = a[0];
        int ma = 0, maksverdi = a[0];

        int verdi = 0;

        for (int i = 1; i < a.length; i++)
        {
            verdi = a[i];

            if (verdi > maksverdi) { maksverdi = verdi; ma = i;}
            else if (verdi < minverdi) {minverdi = verdi; mi = i;}
        }

        return new int[]{mi,ma};
    }
}
