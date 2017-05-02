/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {

    private Sovelluslogiikka l;
    private JTextField tulos;
    private JTextField syote;
    private int lisatty;

    public Summa(Sovelluslogiikka l, JTextField tulos, JTextField syote) {
        this.l = l;
        this.tulos = tulos;
        this.syote = syote;
    }

    @Override
    public void suorita() {
        lisatty = Integer.parseInt(syote.getText());
        l.plus(lisatty);
        syote.setText("");
        tulos.setText("" + l.tulos());
    }

    @Override
    public void peru() {
        l.miinus(lisatty);
        syote.setText("");
        tulos.setText("" + l.tulos());
    }
}
