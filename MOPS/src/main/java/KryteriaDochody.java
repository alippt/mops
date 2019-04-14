import java.math.BigDecimal;

public interface KryteriaDochody {
    BigDecimal KryteriumSamotna = new BigDecimal ( 701 );   //stała wartość z Ustawy
    BigDecimal KryteriumNaOsobeWRodzinie = new BigDecimal ( 528 ); //stała wartość z ustawy

    static BigDecimal dochodNaOsobe(BigDecimal dochod, BigDecimal Osoby) {    //obliczenie dochodu na jedną osobę
        BigDecimal dochodNaOsobe = dochod.divide ( Osoby );

        //zamieniam na doubla żeby zaokrąglić wynik końcowy do dwóch miejsc po przecinku bo to pieniądz

        double tempDochodNaOsobe;
        tempDochodNaOsobe = dochodNaOsobe.doubleValue ();
        tempDochodNaOsobe = KalkulatorOkresowy.roundToTwoPlaces ( tempDochodNaOsobe );

        // i z powrotem do BigD zeby nie rozwaliło nam reszty

        dochodNaOsobe = BigDecimal.valueOf ( tempDochodNaOsobe );
        return dochodNaOsobe;
    }

    static BigDecimal kryteriumRodziny(BigDecimal Osoby) {               //obliczenie kryterium dochodowego dla rodziny
        BigDecimal kryteriumRodziny = Osoby.multiply ( KryteriumNaOsobeWRodzinie ); //ilość osób razy Kryterium na osobę
        return kryteriumRodziny;
    }
}
