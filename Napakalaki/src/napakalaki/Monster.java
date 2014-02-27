/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

/**
 *
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
    
    public String toString(){
        return "Nombre: " + name + "\nNivel: " + Integer.toString(level);
    }
}
