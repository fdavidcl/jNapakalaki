/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.ArrayList;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Clase que representa un jugador
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class Player {
    private boolean dead = true;
    private String name;
    private int level;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    Player(String name) {
        this.name = name;
    }
    
    private void bringToLife() {
        dead = false;
    }
    
    private void incrementLevels(int l) {
        level = min(level+l,10);
    }
    
    private void decrementLevels(int l) {
        level = max(level-l,1);
    }
    
    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }
    
    private void die(){
        for (Treasure t : visibleTreasures)
            CardDealer.getInstance().giveTreasureBack(t);
        
        visibleTreasures.clear();
        
        for (Treasure t : hiddenTreasures)
            CardDealer.getInstance().giveTreasureBack(t);
       
        hiddenTreasures.clear();
    }
    
    private void discardNecklaceIfVisible() {
        for (Treasure t : visibleTreasures){
            if (t.getType() == TreasureKind.NECKLACE){
                CardDealer.getInstance().giveTreasureBack(t);
                visibleTreasures.remove(t);
                break;
            }
        }
    }
    private void dieIfNoTreasures() { }
    
    private int computeGoldCoinsValue(ArrayList<Treasure> t) {
        return 0;
    }
    
    private boolean canIBuyLevels(int l) {
        return false;
    }
    
    public void applyPrize(Prize p) { }
    
    public CombatResult combat(Monster m) {
        return null;
    }
    
    public void applyBadConsequence(BadConsequence bad) { }
    
    public boolean makeTreasureVisible(Treasure t) {
        return false;
    }
    
    public boolean canMakeTreasureVisible(Treasure t) {
        return false;
    }
    
    public void discardVisibleTreasure(Treasure t) { }
    
    public void discardHiddenTreasure(Treasure t) { }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        return false;
    }

    public boolean validState() {
        return false;
    }
    
    public boolean initTreasures() {
        return false;
    }
    
    public boolean hasVisibleTreasures() {
        return false;
    }
    
    public boolean isDead() {
        return dead;
    }

    public int getCombatLevel() {
        return level;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return (ArrayList<Treasure>) hiddenTreasures.clone();
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return (ArrayList<Treasure>) visibleTreasures.clone();
    }
    
    
}
