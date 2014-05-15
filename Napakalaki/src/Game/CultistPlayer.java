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
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(String name, Cultist c) {
        super(name);
        totalCultistPlayers++;
    }

    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
    
    @Override
    public int getCombatLevel() {
        return super.getCombatLevel() + myCultistCard.getSpecialValue();
    }
}
