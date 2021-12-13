package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {

    private static final Scanner scanner = new Scanner(System.in);
    Tekoaly tekoaly;
            
     public KPSTekoaly(Tekoaly t){
         this.tekoaly = t;
     }
    
    
    @Override
    protected String toisenSiirto(String ekanSiirto) {
        
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}
