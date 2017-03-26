/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void pelaajahakuToimii() {
        assertNotNull(stats.search("Gretzky"));
        assertNull(stats.search("leppa"));
    }
    
    @Test
    public void tiimihakuToimii() {
        assertTrue(stats.team("EDM").size() == 3);
        assertTrue(stats.team("DET").size() == 1);
        assertTrue(stats.team("LEP").size() == 0);
    }
    
    @Test 
    public void topscoreToimii() {
        assertTrue(stats.topScorers(0).size() == 1);
        assertTrue(stats.topScorers(1).size() == 2);
        assertTrue(stats.topScorers(4).size() == 5);
        //exception topScorers(5) probably should fix
    }
}