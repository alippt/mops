public interface UO_zwykle extends KryteriaDochody{ //odplłatność rozszerza kryteria bo czerpie wysokości i dochody

//klasa main UO
// interfejsy 3:  zwykle, specjalistyczne , psychiczne


    //  1   podaj dochód całkowity     main
    //  2   ile osób w rodzinie         main
    //  3   get dochód na osobę         z klasy KryteriaDochody

    //      Interfejs OdpłatnośćUO zawiera:
                    // stawki za godzine
                    // przedziały (procent kryterium) z procentem odpłatności (zwykłe

    //      Interfejs odpłatnośćUO ( specjalistyczne bez psych)
                    // stawka
                    //przedziały

    //      interfejs odpłatnośćUO ( specjalistyczne psychiczne)
                    // stawka godzinowa
                    // przedziały (procent kryterium)

    // wynik:
    // podany dochod dla podanej liczby osob daje odpłatnosc zwyklą xxx, zwykla w weekendy, specjalistyczna xxx, specjalistyczna yyy,
    // spec psych xyxyx
}
