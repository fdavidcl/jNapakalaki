/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.min;
/**
 * Clase que representa el mal rollo de un monstruo
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
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
     * Consulta si el mal rollo está vacío
     */
    public boolean isEmpty(){
        return 
            levels == 0 && !death && nVisibleTreasures == 0 && nHiddenTreasures == 0 &&
            specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty(); 
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
    public boolean kills() {
        return death;
    }

    public void substractVisibleTreasure (Treasure t){
        specificVisibleTreasures.remove(t);
    }
    
    public void substractHiddenTreasure (Treasure t){
        specificHiddenTreasures.remove(t);
    }
    
    public BadConsequence adjustToFitTreasureLists (ArrayList<Treasure> vis,
            ArrayList<Treasure> hid){
        ArrayList<TreasureKind> vt = new ArrayList(), ht = new ArrayList(),
                lostvis = new ArrayList(), losthid = new ArrayList();
        
        for (Treasure t : vis)
                vt.add(t.getType());
            
        for (Treasure t : hid)
            ht.add(t.getType());
       
        
        if (specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
            lostvis = (ArrayList<TreasureKind>) vt.subList(0,min(nVisibleTreasures-1,specificVisibleTreasures.size()-1));
            losthid = (ArrayList<TreasureKind>) ht.subList(0,min(nHiddenTreasures-1,specificHiddenTreasures.size()-1));
        }
        else{
            for (TreasureKind t : specificVisibleTreasures)
                if (Collections.frequency(lostvis,t) < Collections.frequency(vt,t))
                    lostvis.add(t);
            
            for (TreasureKind t : specificHiddenTreasures)
                if (Collections.frequency(losthid,t) < Collections.frequency(ht,t))
                    losthid.add(t);
        }
        return new BadConsequence(text,levels,lostvis,losthid);
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
