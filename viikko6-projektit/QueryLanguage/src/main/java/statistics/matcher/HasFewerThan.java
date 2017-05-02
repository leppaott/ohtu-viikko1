/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    private HasAtLeast has;
    public HasFewerThan(int value, String category) {
        this.has = new HasAtLeast(value, category);
    }
    
    @Override
    public boolean matches(Player p) {
        return !has.matches(p);
    }
}
