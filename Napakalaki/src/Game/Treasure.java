/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 * Clase que representa un tesoro
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
class Treasure {
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    
    Treasure(String n, int g, int min, int max, TreasureKind t) {
        name = n;
        goldCoins = g;
        minBonus = min;
        maxBonus = max;
        type = t;
    }
    
    public String getName() {
        return name;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public int getMinBonus() {
        return minBonus;
    }

    public int getMaxBonus() {
        return maxBonus;
    }

    public TreasureKind getType() {
        return type;
    }
    
    public String toString(){
        return type.toString().toUpperCase() + " \"" + name + " \"" + goldCoins + "oro" +
            (type != TreasureKind.NECKLACE ? ", +" + minBonus + "/+" + maxBonus + "bonus)": ")");
    }
}
