package ohtu;

import java.util.Arrays;
import java.util.List;
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

    // step 7
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorinHintaOnTuotteidenHinta() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(6, kori.hinta);
    }

    // step 8
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        kori.lisaaTuote(new Tuote("tuote1", 2));

        List<Ostos> ostokset = kori.ostokset();

        assertEquals(1, ostokset.size());
    }

    // step 9
    @Test
    public void yhdenTuotteenLisaamisenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);

        Ostos ostos = kori.ostokset().get(0);

        assertEquals(1, ostos.lukumaara());
        assertEquals("maito", ostos.tuotteenNimi());
    }

    // step 10
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorissaKaksiOstosOliota() {
        kori.lisaaTuote(new Tuote("tuote1", 2));
        kori.lisaaTuote(new Tuote("tuote2", 2));

        List<Ostos> ostokset = kori.ostokset();

        assertEquals(2, ostokset.size());
    }

    // step 11
    @Test
    public void kahdenSamanTuotteenLisaamisenKorissaYksiOstosOlio() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);


        assertEquals(1, kori.ostokset.size());
    }
    
        // step 12
    @Test
    public void kahdenSamanTuotteenLisaamisenKorissaYksiOstosOlioJollaOikeaNimiJaMaara() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        Ostos ostos = kori.ostokset().get(0);

        assertEquals(2, ostos.lukumaara());
        assertEquals("maito", ostos.tuotteenNimi());
    }
}
