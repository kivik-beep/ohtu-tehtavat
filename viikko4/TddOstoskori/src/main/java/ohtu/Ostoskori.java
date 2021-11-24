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
        Ostos ostos = new Ostos(lisattava);
        if (ostokset.contains(ostos)) {
            ostos.muutaLukumaaraa(1);
        } else {
            ostokset.add(new Ostos(lisattava));
        }
        tavaroita++;
        hinta += lisattava.getHinta();
    }

    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }

    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset

        return null;
    }

    public void tyhjenna() {
        // tyhjentää korin
    }
}
