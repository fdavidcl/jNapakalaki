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
 * @author ncordon
 */
public class BadConsequence {
    public static int TODOS = Integer.MAX_VALUE;
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
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
        death = false;
    }
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        specificVisibleTreasures = (ArrayList<TreasureKind>) tVisible.clone();
        specificHiddenTreasures = (ArrayList<TreasureKind>) tHidden.clone();
        death = false;
    }
    
    BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
        levels = nVisibleTreasures = nHiddenTreasures = 0;
        specificVisibleTreasures = new ArrayList();
        specificHiddenTreasures = new ArrayList();
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
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return (ArrayList<TreasureKind>) specificVisibleTreasures.clone();
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return (ArrayList<TreasureKind>) specificHiddenTreasures.clone();
    }
    
    public boolean getDeath() {
        return death;
    }
    public String toString(){
        return text + ": Niveles: " + Integer.toString(levels)
                + ", Tesoros visibles: " + Integer.toString(nVisibleTreasures)
                + ", Tesoros ocultos: " + Integer.toString(nHiddenTreasures)
                + ", Muerte: " + (death ? "Sí": "No");
    }
    
    public BadConsequence clone() {
        BadConsequence copia;
        if (specificHiddenTreasures.size() > 0 || 
            specificVisibleTreasures.size() > 0) {
            copia = new BadConsequence(text, levels, specificVisibleTreasures,
            specificHiddenTreasures);
        } else if (death == true) {
            copia = new BadConsequence(text, death);
        } else {
            copia = new BadConsequence(text, levels, nVisibleTreasures,
            nHiddenTreasures);
        }
        return copia;
    }
}
