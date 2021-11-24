package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);
        varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "makkara", 7));
        k = new Kauppa(varasto, pankki, viite);
    }

    @Test
    public void ostoksenPaattyessaPankinMetodiaTilisiirtoKutsutaanOikein() {

        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));
    }

    @Test
    public void useammallaTuotteellaPankinMetodiaTilisiirtoKutsutaan() {

        when(varasto.saldo(2)).thenReturn(10);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli makkaraa
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(12));
    }

    @Test
    public void useammanSamanTuotteenOstoksessaPankinMetodiaTilisiirtoKutsutaan() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(10));
    }

    @Test
    public void ostosJossaLoppuOlevaaTuotettaOnnistuuKunPankinMetodiaTilisiirtoKutsutaan() {
        when(varasto.saldo(2)).thenReturn(0);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli makkaraa
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));
    }

    @Test
    public void edellisetOstoksetNollaantuvatKunKutsutaanmetodiaAloitaAsiointi() {
        when(varasto.saldo(2)).thenReturn(10);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa

        k.aloitaAsiointi();   // aloitetaan asiointi alusta
        k.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli makkaraa
        k.tilimaksu("kirsi", "54321");

        verify(pankki).tilisiirto(eq("kirsi"), eq(42), eq("54321"), eq("33333-44455"), eq(7));
    }
    
        @Test
    public void tuotteidenPoistoKoristaOnnistuu() {
        k.aloitaAsiointi();   
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.poistaKorista(1);
        k.tilimaksu("kirsi", "54321");

        verify(pankki).tilisiirto(eq("kirsi"), eq(42), eq("54321"), eq("33333-44455"), eq(5));
    }

}
