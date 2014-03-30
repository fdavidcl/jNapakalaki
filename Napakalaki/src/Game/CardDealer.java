/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.ArrayList;

/**
 * Clase singleton que reparte y gestiona las cartas
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class CardDealer {
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedTreasures;
    private ArrayList<Monster> unusedTreasures;
    private static final CardDealer instance = new CardDealer();
    
    private CardDealer() {}
    
    private void initTreasureCardDeck() { }
    
    private void initMonsterCardDeck() { }
    
    private void shuffleTreasures() { }
    
    private void shuffleMonsters() { }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    public Treasure nextTreasure() {
        return null;
    }
    
    public Monster nextMonster() {
        return null;
    }
    
    public void giveTreasureBack(Treasure t) { }
    
    public void giveMonsterBack(Monster m) { }
    
    public void initCards() { }
}
