/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

public class KPSFactory {

    private KPSFactory() {
    }

    public static KPS newKPS(char type) {
        if (type == 'a') {
            return new KPSImpl(new Human(), new Human(), false);
        } else if (type == 'b') {
            return new KPSImpl(new Human(), new Tekoaly(), true);
        } else if (type == 'c') {
            return new KPSImpl(new Human(), new TekoalyParannettu(20), true);
        }
        return null;
    }
}
