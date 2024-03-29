/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 * Clase que representa un monstruo
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class Monster implements Card{
    private String name;
    private int level;
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer;

    public Monster(String name, int level, BadConsequence badConsequence, Prize prize) {
        this.levelChangeAgainstCultistPlayer = 0;
        this.name = name;
        this.level = level;
        this.badConsequence = badConsequence;
        this.prize = prize;
    }

    public Monster(String name, int level, BadConsequence badConsequence, Prize prize, int levelChangeAgainstCultistPlayer){
        this(name,level,badConsequence,prize);
        this.levelChangeAgainstCultistPlayer = levelChangeAgainstCultistPlayer;
    }
    

    /**
     * Consultor de nombre
     * @return Nombre del monstruo
     */
    public String getName() {
        return name;
    }

    /**
     * Consultor de nivel
     * @return Nivel del monstruo
     */
    public int getLevel() {
        return level;
    }

    /**
     * Consultor de buen rollo
     * @return Buen rollo del monstruo
     */
    public Prize getPrize() {
        return prize;
    }

    /**
     * Consultor de mal rollo
     * @return Mal rollo del monstruo
     */
    public BadConsequence getBadConsequence() {
        return badConsequence;
    }

    /**
     * Convierte a cadena el monstruo
     * @return Cadena con la información del monstruo
     */
    public String toString() {
        return "Nombre: " + name + ", Nivel: " + Integer.toString(level)
                + "\n\tBuen rollo: " + prize.toString() + "\n\tMal rollo: "
                + badConsequence.toString() + "\n";
    }
    
    @Override
    public int getBasicValue(){
        return getLevel();
    }
    
    @Override
    public int getSpecialValue(){
        return getLevel() + levelChangeAgainstCultistPlayer;
    }
}
