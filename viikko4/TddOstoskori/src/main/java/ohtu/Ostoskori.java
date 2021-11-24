package ohtu;

import java.util.*;

public class Ostoskori {

    ArrayList<Ostos> ostokset = new ArrayList<>();
    int hinta;
    int tavaroita;

    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2   
        return tavaroita;
    }

    public int hinta() {
        // kertoo korissa olevien tuotteiden yhteenlasketun hinnan
        if (ostokset.isEmpty()) {
            return 0;
        }
        return hinta;
    }

    public void lisaaTuote(Tuote lisattava) {
        boolean korissa = false;
        for (Ostos ostos : ostokset) {
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(1);
                korissa = true;
            }
        }

        if (!korissa) {
            ostokset.add(new Ostos(lisattava));
        }
        tavaroita++;
        hinta += lisattava.getHinta();
    }

    public void poista(Tuote poistettava) {
        for (Ostos o : ostokset) {
            if (o.tuotteenNimi().equals(poistettava.getNimi())) {
                o.muutaLukumaaraa(-1);
                hinta -= poistettava.getHinta();
                tavaroita--;
            }
        }

        for (int i = 0; i < ostokset.size(); i++) {
            if (ostokset.get(i).lukumaara() == 0) {
                ostokset.remove(i);
                i--;
            }
        }
    }

    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
        return ostokset;
    }

    public void tyhjenna() {
        // tyhjentää korin
        ostokset = new ArrayList<>();
        tavaroita = 0;
        hinta = 0;
    }
}
