/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

/**
 *
 * @author kxkivi
 */
public class Not implements Matcher {
    private Matcher m;

    public Not(Matcher matcher) {
        this.m = matcher;
    }

    @Override
    public boolean matches(Player p) {
        if (m.matches(p)) return false;
        return true;
    }  
}
