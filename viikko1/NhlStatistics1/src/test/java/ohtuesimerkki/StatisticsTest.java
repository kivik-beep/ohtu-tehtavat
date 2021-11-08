/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kxkivi
 */
public class StatisticsTest {
    Statistics stats;
    private List<Player> players;
    
    @Before
    public void setUp() {
        Reader pelaajat = new TestPlayers();
        stats = new Statistics(pelaajat);
        players = pelaajat.getPlayers();
    }
    
    @Test
    public void konstruktoriToimii() {
        Reader uudetPelaajat = new TestPlayers();
        assertEquals(uudetPelaajat, players);
    }
    
    @Test
    public void pelaajahakuPalauttaaPelaajan() {
        assertEquals(stats.search("Claude Giroux"), players.get(0));
    }
    
    @Test
    public void pelaajahakuPalauttaaNull() {
        assertEquals(stats.search("Aku Ankka"), null);
    }
    
    @Test
    public void tiimihakuToimii() {
        players.remove(players.lastIndexOf(players));
        assertEquals(stats.team("PHI"), players);
    }
    @Test
    public void tiimihakuToimii2() {
        ArrayList edmPelaajat = new ArrayList<>();
        edmPelaajat.add(new Player("Connor McDavid", "EDM", 33, 72));
        
        assertEquals(stats.team("EDM"), edmPelaajat);
    }
    
    @Test
    public void toplistaToimii() {
        Collections.sort(players);
        ArrayList<Player> best = new ArrayList<>();
        
        for(int i = players.size(); i > players.size()-10; i--){
            best.add(players.get(i));
        }
        assertEquals(best, stats.topScorers(10));
    }
}

class TestPlayers implements Reader {

    ArrayList<Player> players;

    public TestPlayers() {
        players = new ArrayList<>();

        //Philadelphia Flyers 2021
        players.add(new Player("Claude Giroux", "PHI", 16, 27));
        players.add(new Player("Justin Braun", "PHI", 1, 5));
        players.add(new Player("James van Riemsdyk", "PHI", 17, 26));
        players.add(new Player("Jakub Voracek", "PHI", 9, 34));
        players.add(new Player("Nate Prosser", "PHI", 1, 1));
        players.add(new Player("Kevin Hayes", "PHI", 12, 19));
        players.add(new Player("Andy Andreoff", "PHI", 0, 0));
        players.add(new Player("Sean Couturier", "PHI", 18, 23));
        players.add(new Player("Scott Laughton", "PHI", 9, 11));
        players.add(new Player("Shayne Gostisbehere", "PHI", 9, 11));
        players.add(new Player("Robert Hagg", "PHI", 2, 3));
        players.add(new Player("Samuel Morin", "PHI", 1, 0));
        players.add(new Player("Travis Sanheim", "PHI", 3, 12));
        players.add(new Player("Nicolas Aube-Kubel", "PHI", 3, 9));
        players.add(new Player("Oskar Lindblom", "PHI", 8, 6));
        players.add(new Player("David Kase", "PHI", 0, 0));
        players.add(new Player("Travis Konecny", "PHI", 11, 23));
        players.add(new Player("Ivan Provorov", "PHI", 7, 19));
        players.add(new Player("Philippe Myers", "PHI", 1, 10));
        players.add(new Player("Wade Allison", "PHI", 4, 3));
        players.add(new Player("Carsen Twarynski", "PHI", 0, 0));
        players.add(new Player("Connor Bunnaman", "PHI", 0, 1));
        players.add(new Player("Tanner Laczynski", "PHI", 0, 0));
        players.add(new Player("Nolan Patrick", "PHI", 4, 5));
        players.add(new Player("Morgan Frost", "PHI", 0, 0));
        players.add(new Player("Maksim Sushko", "PHI", 0, 0));
        players.add(new Player("Joel Farabee", "PHI", 20, 18));
        players.add(new Player("Egor Zamula", "PHI", 0, 0));
        players.add(new Player("Cam York", "PHI", 0, 0));
        players.add(new Player("Jackson Cates", "PHI", 0, 1));
        players.add(new Player("Brian Elliott", "PHI", 0, 0));
        players.add(new Player("Alex Lyon", "PHI", 0, 0));
        players.add(new Player("Carter Hart", "PHI", 0, 0));
        
        players.add(new Player("Connor McDavid", "EDM", 33, 72));
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

}
