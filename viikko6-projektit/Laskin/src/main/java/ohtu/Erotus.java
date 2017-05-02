/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {

    private Sovelluslogiikka l;
    private JTextField tulos;
    private JTextField syote;
    private int edellinen;

    public Erotus(Sovelluslogiikka l, JTextField tulos, JTextField syote) {
        this.l = l;
        this.tulos = tulos;
    }

    @Override
    public void suorita() {
        edellinen = Integer.parseInt(syote.getText());
        l.miinus(edellinen);
        syote.setText("");
        tulos.setText("" + l.tulos());
    }

    @Override
    public void peru() {
        l.plus(edellinen);
        syote.setText("");
        tulos.setText("" + l.tulos());
    }
}
