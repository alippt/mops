
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BigDecimal dzielnik = new BigDecimal ( 2 );  //chyba nie jest tu wcale potrzebny
        Scanner skaner = new Scanner ( System.in );
        //popbieramy osoby
        System.out.println ( "Podaj liczbe osob" );
        BigDecimal a = skaner.nextBigDecimal ();

//podajemy dochód w skali do dwóch miejsc (bez "setScale" nie chciał przyjąć więcej niż jedno miejsce po przecinku
        System.out.println ( "Podaj dochod osoby/rodziny" );
        BigDecimal b = skaner.nextBigDecimal ().setScale ( 2 );

        KalkulatorOkresowy kalkulatorOkresowy = new KalkulatorOkresowy ( a, b );
        // Przedstawiamy wyniki dla podanych wartosci
        System.out.println ( kalkulatorOkresowy.zasilekOkresowy ( a, b ) );
        System.out.println ( "Dochód na osobę w rodzinie wynosi:" + " " + (KryteriaDochody.dochodNaOsobe ( b, a )) + " " + "zł" );
        if (a.intValue () > 1) {
            System.out.println ( "Potwierdzenie decyzji: Kryterium rodziny wynosi:" + " " + (KryteriaDochody.kryteriumRodziny ( a )) + " " + "zł (" + a + "*" + (KryteriaDochody.KryteriumNaOsobeWRodzinie) + ")" + " " );
        } else if (a.intValue () == 1) {
            System.out.println ( "Potwierdzenie decyzji: Kryterium dla osoby samotnej wynosi:" + " " + (KryteriaDochody.KryteriumSamotna) + " " + "zł\n" + "(" + KryteriaDochody.KryteriumSamotna + " - " + b + "/ 2) =" + " " + kalkulatorOkresowy.zasilekOkresowy ( a, b ) );
        } else {
            System.out.println ( "Coś poszło nie tak" );
        }
    }
}



