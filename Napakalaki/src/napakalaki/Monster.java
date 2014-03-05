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
 */
public class Monster {
    private String name;
    private int level;
    private Prize prize;
    private BadConsequence bad;
    
    Monster(String name, int level, BadConsequence bad, Prize prize){
        this.name=name;
        this.level=level;
        this.bad=bad;
        this.prize=prize;
    }
    
    public String getName(){
        return name;
    }
    
    public int getLevel(){
        return level;
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    public BadConsequence getBadConsequence(){
        return bad;
    }
    
    public String toString(){
        return "Nombre: " + name + ", Nivel: " + Integer.toString(level);
    }
}
