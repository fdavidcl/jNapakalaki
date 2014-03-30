/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;
import java.util.ArrayList;
/**
 * Clase del juego principal
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class Napakalaki {
    private Player currentPlayer;
    
    private ArrayList<Player> players;
    
    private static final Napakalaki instance = new Napakalaki();
    
    private Napakalaki() {}
    
    private void initPlayers (String names){}
    
    private Player nextPlayer(){
        return null;
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult combat(){
        return null;
    }
    
    public void discardVisibleTreasure (Treasure t){}
    
    public void discardHiddenTreasure (Treasure t){}
    
    public boolean makeTreasureVisible (Treasure t){
        return true;
    }
    
    public boolean buyLevels (ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        return true;
    }
    
    public void initGame (ArrayList<String> players) {}
    
    public Player getCurrentPlayer(){
        return null;
    }
    
    public Monster getCurrentMonster(){
        return null;
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        return true;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return null;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return null;
    }
    
    public boolean nextTurn(){
        return true;
    }
    
    public boolean nextTurnAllowed(){
        return true;
    }
    
    public boolean endOfGame(CombatResult result){
        return true;
    }
    
    
    /**
     * Programa principal
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }   
}
 
