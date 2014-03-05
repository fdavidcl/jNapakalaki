/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

/**
 *
 * @author fdavidcl
 * @author ncordon
 */
public class Prize {
    private int treasures;
    private int levels;
    
    Prize(int treasures, int levels) {
        this.treasures = treasures;
        this.levels = levels;
    }
    public int getTreasures() {
        return treasures;
    }
    public int getLevels() {
        return levels;
    }
    public String toString(){
        return "Tesoros: " + Integer.toString(treasures) + ", Niveles: " + Integer.toString(levels);
    }
    
    public Prize clone() {
        return new Prize(treasures, levels);
    }
}
