/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.querybuilder;

import java.util.ArrayList;
import java.util.List;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    private List<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<>();
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... list) {
        matchers.add(new Or(list));
        return this;
    }

    public Matcher build() {
        Matcher ret = new And(matchers.toArray(new Matcher[matchers.size()]));
        matchers.clear();
        return ret;
    }
}
