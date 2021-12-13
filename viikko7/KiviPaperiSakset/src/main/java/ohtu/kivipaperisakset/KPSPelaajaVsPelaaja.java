package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    protected String toisenSiirto(String ekanSiirto) {
        System.out.print("Toisen pelaajan siirto: ");
        System.out.println();
        String tokanSiirto = scanner.nextLine();

        return tokanSiirto;
    }
}
