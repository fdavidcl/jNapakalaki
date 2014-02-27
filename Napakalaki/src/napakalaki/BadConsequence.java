/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

import java.util.ArrayList;
/**
 *
 * @author fdavidcl
 */
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    BadConsequence(String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        specificVisibleTreasures = (ArrayList<TreasureKind>) tVisible.clone();
        specificHiddenTreasures = (ArrayList<TreasureKind>) tHidden.clone();
    }
    
    BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
    }
    
    public String getText() {
        return text;
    }
    
    public int getLevels() {
        return levels;
    }
    
    public int getVisibleTreasures() {
        return nVisibleTreasures;
    }
    
    public int getHiddenTreasures() {
        return nHiddenTreasures;
    }
    
    public boolean getDeath() {
        return death;
    }
    public String toString(){
        return text + ": Levels: " + Integer.toString(levels)
                + ", Visible treasures: " + Integer.toString(nVisibleTreasures)
                + ", Hidden treasures: " + Integer.toString(nHiddenTreasures)
                + ", Death: " + (death ? "Sí": "No");
    }
}
