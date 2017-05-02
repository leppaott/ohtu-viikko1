/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.Arrays;
import java.util.List;
import statistics.Player;

public class Or implements Matcher {

    private final List<Matcher> matchers;

    public Or(Matcher... matchers) {
        this.matchers = Arrays.asList(matchers);
    }

    @Override
    public boolean matches(Player p) {
        return matchers.stream().anyMatch(m -> m.matches(p));
    }
}
