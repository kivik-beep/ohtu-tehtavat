package ohtu;

import java.util.*;

public class Ostoskori {

    ArrayList<Ostos> ostokset = new ArrayList<>();

    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2   
        int tavaroita = 0;
        for (Ostos o : ostokset) {
            tavaroita += o.lukumaara();
        }
        return tavaroita;
    }

    public int hinta() {
        // kertoo korissa olevien tuotteiden yhteenlasketun hinnan
        int hinta = 0;
        for (Ostos o : ostokset) {
            hinta += o.hinta();
        }
        return hinta;
    }

    public void lisaaTuote(Tuote lisattava) {
        for (Ostos ostos : ostokset) {
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(1);
                return;
            }
        }

        ostokset.add(new Ostos(lisattava));

    }

    public void poista(Tuote poistettava) {
        // poistaa tuotteen
        for (int i = 0; i < ostokset.size(); i++) {
            if (ostokset.get(i).tuotteenNimi().equals(poistettava.getNimi())) {
                ostokset.get(i).muutaLukumaaraa(-1);
            }
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
    }
}
