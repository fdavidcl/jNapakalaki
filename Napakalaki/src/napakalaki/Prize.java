/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

/**
 * Clase que representa el buen rollo de un monstruo
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class Prize {
    private int treasures;
    private int levels;
    
    Prize(int treasures, int levels) {
        this.treasures = treasures;
        this.levels = levels;
    }

    /**
     * Informa de los tesoros que se consiguen
     * @return Tesoros
     */
    public int getTreasures() {
        return treasures;
    }

    /**
     * Consulta los niveles que se consiguen
     * @return Niveles
     */
    public int getLevels() {
        return levels;
    }

    /**
     * Pasa el buen rollo a una cadena
     * @return Cadena que representa el buen rollo
     */
    public String toString(){
        return "Tesoros: " + Integer.toString(treasures) + ", Niveles: " + Integer.toString(levels);
    }
}
