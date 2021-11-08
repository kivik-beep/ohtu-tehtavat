/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.*;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12)); //16
            players.add(new Player("Lemieux", "PIT", 45, 54));//99
            players.add(new Player("Kurri", "EDM", 37, 53));  //90
            players.add(new Player("Yzerman", "DET", 42, 56));//98
            players.add(new Player("Gretzky", "EDM", 35, 89));//124

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void konstruktoriLuoUudenStatsin() {

    }

    @Test
    public void etsiPelaajaPalauttaaPelaajan() {
        Player one = stats.search("Semenko");
        Player two = readerStub.getPlayers().get(0);
        assertEquals(one.toString(), two.toString());
    }

    @Test
    public void etsiPelaajaPalauttaaNull() {

        assertEquals(stats.search("Hermanni"), null);
    }

    @Test
    public void samanJoukkueenPelaajatLoytyvat() {
        String first = readerStub.getPlayers().get(3).toString();
        String other = "";

        for (int i = 0; i < stats.team("DET").size(); i++) {
            other = other + stats.team("DET").get(i).toString();
        }

        assertEquals(first, other);
    }

    @Test
    public void parhaidenPelaajienKartoitusToimii() {
        ArrayList<Player> j = new ArrayList<>();
        
        j.add(readerStub.getPlayers().get(4));
        j.add(readerStub.getPlayers().get(1));
        j.add(readerStub.getPlayers().get(3));
        j.add(readerStub.getPlayers().get(2));
        j.add(readerStub.getPlayers().get(0));
        
        List<Player> k = stats.topScorers(4);
        
        boolean samat = true;
        
        for(int i = 0; i < 5; i++){
            if(j.get(i).toString().equals(k.get(i).toString())){
                samat = true;
            } else {
                samat = false;
            }
        }
        
        Assert.assertTrue(samat);
    }

}
