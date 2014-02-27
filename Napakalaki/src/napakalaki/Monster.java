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
