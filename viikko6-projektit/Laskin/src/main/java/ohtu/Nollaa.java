/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private Sovelluslogiikka l;
    private JTextField tulos;
    private JTextField syote;
    private int edellinen;

    public Nollaa(Sovelluslogiikka l, JTextField tulos, JTextField syote) {
        this.l = l;
        this.tulos = tulos;
    }

    @Override
    public void suorita() {
        edellinen = l.tulos();
        syote.setText("");
        tulos.setText("");
        l.nollaa();
    }

    @Override
    public void peru() {
        tulos.setText("" + edellinen);
    }
}
