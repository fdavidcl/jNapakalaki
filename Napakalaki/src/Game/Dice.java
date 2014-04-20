/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.Random;

/**
 * Clase singleton representando al dado
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class Dice {
    private static final Dice instance = new Dice();
    
    private Dice() { }
    
    public static Dice getInstance() {
        return instance;
    }
    
    public int nextNumber() {
        return new Random().nextInt(6) + 1;
    }
}
