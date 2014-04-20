/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;
import java.util.ArrayList;
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
    
    public void substractVisibleTreasure (Treasure t){
        if (!specificVisibleTreasures.remove(t))
            if (nVisibleTreasures > 0)
                nVisibleTreasures -= 1;
    }
    
    public void substractHiddenTreasure (Treasure t){
        if (!specificHiddenTreasures.remove(t))
            if (nHiddenTreasures > 0)
                nHiddenTreasures -= 1;
    }
    
    public BadConsequence adjustToFitTreasureLists (ArrayList<Treasure> vis,
            ArrayList<Treasure> hid){
        ArrayList<TreasureKind> lostvis, losthid;
        lostvis = new ArrayList();
        losthid = new ArrayList();
        
        if (specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
            for (Treasure t : vis.subList(0,min(nVisibleTreasures-1,specificVisibleTreasures.size()-1)))
                lostvis.add(t.getType());
            
            for (Treasure t : hid.subList(0,min(nHiddenTreasures-1,specificHiddenTreasures.size()-1)))
                losthid.add(t.getType());
        }
        else{
            ArrayList<TreasureKind> vt = new ArrayList();
            ArrayList<TreasureKind> ht = new ArrayList();
            
            for (Treasure t : vis)
                vt.add(t.getType());
            
            for (Treasure t : hid)
                ht.add(t.getType());
            
            for (TreasureKind t : specificVisibleTreasures){
                if (vt.contains(t)){
                    lostvis.add(t);
                    vt.remove(t);
                }
            }
            
            for (TreasureKind t : specificHiddenTreasures){
                if (ht.contains(t)){
                    losthid.add(t);
                    ht.remove(t);
                }
            }
        }
        return new BadConsequence(text,levels,lostvis,losthid);
    }
}
