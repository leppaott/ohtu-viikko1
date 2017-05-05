/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

public class KPSImpl implements KPS {

    private final Tuomari tuomari;
    private final Player eka, toka;
    private final boolean computer;

    public KPSImpl(Player eka, Player toka, boolean computerSays) {
        this.eka = eka;
        this.toka = toka;
        this.tuomari = new Tuomari();
        this.computer = computerSays;
    }

    @Override
    public void pelaa() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = eka.annaSiirto();

        if (!computer) {
            System.out.print("Toisen pelaajan siirto: ");
        }

        String tokanSiirto = toka.annaSiirto();

        if (computer) {
            System.out.println("Tietokone valitsi: " + tokanSiirto);
        }

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = eka.annaSiirto();

            if (!computer) {
                System.out.print("Toisen pelaajan siirto: ");
            }

            tokanSiirto = toka.annaSiirto();

            if (computer) {
                System.out.println("Tietokone valitsi: " + tokanSiirto);
            }

            toka.asetaSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}
