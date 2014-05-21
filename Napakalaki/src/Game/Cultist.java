/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class Cultist implements Card {
    private String name;
    private int gainedLevels;
    
    Cultist(String name, int gainedLevels) {
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    @Override
    public int getBasicValue() {
        return gainedLevels;
    }
    @Override
    public int getSpecialValue() {
        return getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
    
}
