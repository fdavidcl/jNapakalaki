/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

/**
 *
 * @author fdavidcl
 * @author nuwanda
 * 
 */
public class Monster {
    private String name;
    private int level;
    private Prize prize;
    private BadConsequence bad;
    
    Monster(String name, int level, BadConsequence bad, Prize prize){
        this.name = name;
        this.level = level;
        this.bad = bad.clone();
        this.prize = prize.clone();
    }
    
    public String getName(){
        return name;
    }
    
    public int getLevel(){
        return level;
    }
    
    public Prize getPrize(){
        return prize.clone();
    }
    
    public BadConsequence getBadConsequence(){
        return bad.clone();
    }
    
    public String toString(){
        return "Nombre: " + name + ", Nivel: " + Integer.toString(level)
                + "\n\tBuen rollo: " + prize.toString() + "\n\tMal rollo: "
                + bad.toString() + "\n";
    }
    
    public Monster clone() {
        return new Monster(name, level, bad, prize);
    }
}
