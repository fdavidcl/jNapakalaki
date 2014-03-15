/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;
import java.util.ArrayList;
/**
 * Clase que representa el mal rollo de un monstruo
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class BadConsequence {
    public static final int ALLLEVELS = Integer.MAX_VALUE;
    
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
    
    /**
     * Consultor del texto
     * @return Texto del mal rollo
     */
    public String getText() {
        return text;
    }
    
    /**
     * Consultor de niveles
     * @return Niveles que se pierden
     */
    public int getLevels() {
        return levels;
    }
    
    /**
     * Consultor de tesoros visibles
     * @return Número de tesoros visibles perdidos
     */
    public int getVisibleTreasures() {
        return nVisibleTreasures;
    }
    
    /**
     * Consultor de tesoros ocultos
     * @return Número de tesoros ocultos perdidos
     */
    public int getHiddenTreasures() {
        return nHiddenTreasures;
    }
    
    /**
     * Consultor de tesoros visibles específicos
     * @return Lista de tesoros visibles perdidos
     */
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return (ArrayList<TreasureKind>) specificVisibleTreasures.clone();
    }
    
    /**
     * Consultor de tesoros ocultos específicos
     * @return Lista de tesoros ocultos perdidos
     */
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return (ArrayList<TreasureKind>) specificHiddenTreasures.clone();
    }
    
    /**
     * Consultor de muerte
     * @return Informa de si el mal rollo supone la muerte
     */
    public boolean getDeath() {
        return death;
    }

    /**
     * Pasa el mal rollo a cadena
     * @return Cadena con información del mal rollo
     */
    public String toString(){
        return text + ": Niveles: " + Integer.toString(levels)
                + ", Tesoros visibles: " + (specificVisibleTreasures.isEmpty() ?
                    Integer.toString(nVisibleTreasures) : specificVisibleTreasures.toString())
                + ", Tesoros ocultos: " + (specificHiddenTreasures.isEmpty() ?
                    Integer.toString(nHiddenTreasures) : specificHiddenTreasures.toString())
                + ", Muerte: " + (death ? "Sí": "No");
    }
}
