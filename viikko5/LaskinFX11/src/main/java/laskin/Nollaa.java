/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author kxkivi
 */
public class Nollaa implements Komento {
    
    Sovelluslogiikka sovellus;
    TextField tuloskentta; 
    TextField syotekentta;
    String edellinen;
    Button nollaa;
    Button undo;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }

    @Override
    public void suorita() {
        edellinen = tuloskentta.toString();
        
        sovellus.nollaa();
        
        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    @Override
    public void peru(){
        tuloskentta.setText(this.edellinen);
    }
}
