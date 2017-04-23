package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IllegalArgumentException("parametrit väärin");//heitin vaan jotain :D
        }
        ljono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, 5);
    }

    public IntJoukko() {
        this(5, 5);
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm++] = luku;
            if (alkioidenLkm >= ljono.length) {
                ljono = Arrays.copyOf(ljono, ljono.length + kasvatuskoko);
            }
            return true;
        }
        return false;
    }

    public void lisaa(IntJoukko joukko) {
        for (int i = 0; i < joukko.alkioidenLkm; i++) {
            lisaa(joukko.getAt(i));
        }
    }

    public void poista(IntJoukko joukko) {
        for (int i = 0; i < joukko.alkioidenLkm; i++) {
            poista(joukko.getAt(i));
        }
    }

    public boolean kuuluu(int luku) {
        return Arrays.stream(ljono).anyMatch(i -> i == luku);
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (ljono[i] == luku) {
                System.arraycopy(ljono, i + 1, ljono, i, ljono.length - i - 1);
                this.alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < alkioidenLkm; i++) {
            sb.append(ljono[i] + ", ");
        }
        int i = sb.lastIndexOf(",");
        if (i != -1) {
            sb.delete(i, i + 2);
        }
        return sb.append("}").toString();
    }

    public int getAt(int i) {
        if (i >= alkioidenLkm) {
            throw new IndexOutOfBoundsException("oops");
        }
        return ljono[i];
    }

    public int[] toIntArray() {
        return Arrays.copyOfRange(ljono, 0, alkioidenLkm);
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();
        uusiJoukko.lisaa(a);
        uusiJoukko.lisaa(b);
        return uusiJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            if (b.kuuluu(a.getAt(i))) {
                uusiJoukko.lisaa(a.getAt(i));
            }
        }
        return uusiJoukko;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();
        uusiJoukko.lisaa(a);
        uusiJoukko.poista(b);
        return uusiJoukko;
    }
}
