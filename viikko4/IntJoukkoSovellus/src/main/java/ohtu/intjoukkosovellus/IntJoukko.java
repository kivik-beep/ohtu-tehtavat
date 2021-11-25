package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;
    private int lukuja = 0;

    public IntJoukko() {
        this.kasvatuskoko = 5;
        this.ljono = new int[5];
    }

    public IntJoukko(int kapasiteetti) {
        this.kasvatuskoko = 5;
        if (kapasiteetti > 0) ljono = new int[kapasiteetti];
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti > 0 && kasvatuskoko > 0) {
            ljono = new int[kapasiteetti];
            this.kasvatuskoko = kasvatuskoko;
        }
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[lukuja] = luku;
            lukuja++;
            if (lukuja - ljono.length == 0) kasvataTaulukkoa();
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < lukuja; i++) {
            if (luku == ljono[i]) return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < lukuja; i++) {
            if (luku == ljono[i]) {
                for (int j = i; j < lukuja - 1; j++) {
                    ljono[j] = ljono[j + 1];
                }
                lukuja--;
                return true;
            }
        }
        return false;
    }

    private void kasvataTaulukkoa() {
        int[] uusi = new int[lukuja + kasvatuskoko];
        System.arraycopy(ljono, 0, uusi, 0, lukuja);
        ljono = uusi;
    }

    public int mahtavuus() {
        return lukuja;
    }

    @Override
    public String toString() {
        String sana = Arrays.toString(toIntArray());
        return "{" + sana.substring(1, sana.length() - 1) + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[lukuja];
        System.arraycopy(ljono, 0, taulu, 0, lukuja);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        for (int i = 0; i < b.lukuja; i++) a.lisaa(b.ljono[i]);
        return a;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        for (int i = 0; i < a.lukuja; i++) {
            if (!b.kuuluu(a.ljono[i])) a.poista(a.ljono[i]);
        }
        return a;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        for (int i = 0; i < a.lukuja; i++) {
            if (b.kuuluu(a.ljono[i])) a.poista(a.ljono[i]);
        }
        return a;
    }
}
