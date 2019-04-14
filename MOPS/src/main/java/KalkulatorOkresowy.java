import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.math.BigDecimal;

public class KalkulatorOkresowy implements KryteriaDochody {
    BigDecimal osoby;
    BigDecimal dochod;
    BigDecimal dzielnik = new BigDecimal ( 2 );  //nie wiem czy to potrzebne ale w działaniu nie chciał mi przyjąc samej wartości, żadał BigD.

    public KalkulatorOkresowy(BigDecimal osoby, BigDecimal dochod) {
        this.osoby = osoby;
        this.dochod = dochod;
    }

    public BigDecimal getOsoby() {
        return osoby;
    }

    public BigDecimal getDochod() {
        return dochod;
    }

    //Obliczamy wysokość zasiłku okresowego zarówno dla rodziny jak i samotnego

    public String zasilekOkresowy(BigDecimal osoby, BigDecimal dochod) {
        BigDecimal IleZasilekOkresowy = new BigDecimal ( 0 );

//rozróżnienie czy rodzina czy samotny, jeśli powyżej 1 osoby to rodzina
        if ((osoby.intValue () > 1)) {
            int jest = dochod.compareTo ( KryteriaDochody.kryteriumRodziny ( osoby ) ); //jeśłi dochód wyższy niż kryterium
            if (jest == 1) {
                return "przekroczone kryterium";
            }
            //jeśli dochód niższy lub równy kryterium
            if (jest <= 1) {
                IleZasilekOkresowy = ((KryteriaDochody.kryteriumRodziny ( osoby )).subtract ( dochod )).divide ( dzielnik );//dzielnik zawsze jest 2 ale nie chciał przyjąć
            }
            //jak wyżej sytuacja tylko dla samotnej osoby
        } else if ((osoby.intValue () == 1)) {
            int jest2 = dochod.compareTo ( KryteriaDochody.KryteriumSamotna );  //czy dochód przekracza kryterium
            if (jest2 == 1) {
                return "przekroczone kryterium";
            }
            if (jest2 <= 1) {   //jeśli nie przekracza to liczymy zgodnie z rozporzadzeniem
                IleZasilekOkresowy = (((KryteriaDochody.KryteriumSamotna).subtract ( dochod )).divide ( dzielnik ));
            }
        }
        //zamieniam IleZasiłekOkresowy na doubla żeby zaokrąglić wynik końcowy do dwóch miejsc po przecinku bo to pieniądz
        double d;
        d = IleZasilekOkresowy.doubleValue ();
        d = roundToTwoPlaces ( d );
        return ("Zasiłek okresowy wyniesie:" + d + " " + "zł");
    }

    //metoda do zaokrąglania wyniku (z neta)
    public static double roundToTwoPlaces(double IleZasiłekDouble) {
        return ((long) (IleZasiłekDouble < 0 ? IleZasiłekDouble * 100 - 0.5 : IleZasiłekDouble * 100 + 0.5)) / 100.0;
    }


}
