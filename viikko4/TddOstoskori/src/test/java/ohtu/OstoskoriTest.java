package ohtu;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;

    @Before
    public void setUp() {
        kori = new Ostoskori();
    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() {
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.tavaroitaKorissa());
    }

    // step 2
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiTuote() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);

        assertEquals(1, kori.tavaroitaKorissa());
    }

    // step 3
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorinHintaOnTuotteenHinta() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);

        assertEquals(3, kori.hinta());
    }

    // step 4
    @Test
    public void kahdenTuotteenLisaamisenJalkeenKorissaOnKaksiTavaraa() {
        Tuote maito = new Tuote("maito", 3);
        Tuote mehu = new Tuote("mehu", 4);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(mehu);

        assertEquals(2, kori.tavaroitaKorissa());
    }
    
    // step 5
    @Test
    public void kahdenTuotteenLisaamisenJalkeenKorinHintaOnTuotteidenHinta() {
        Tuote maito = new Tuote("maito", 3);
        Tuote mehu = new Tuote("mehu", 4);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(mehu);

        assertEquals(7, kori.hinta);
    }
    
    // step 6
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaOnKaksiTavaraa() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(2, kori.tavaroitaKorissa());
    }
}
