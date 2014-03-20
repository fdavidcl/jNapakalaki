/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 *
 * @author fdavidcl
 */
public class CardDealer {
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
    
    
}
