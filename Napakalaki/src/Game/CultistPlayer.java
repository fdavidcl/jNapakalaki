/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;
import java.util.ArrayList;
/**
 *
 * @author fdavidcl
 */
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c) {
        super(p);
        totalCultistPlayers++;
    }

    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
    
    @Override
    public int getCombatLevel() {
        return super.getCombatLevel() + myCultistCard.getSpecialValue();
    }
    
    @Override
    public boolean shouldConvert(){
        return false;
    }
    
    @Override
    public int getOponentLevel(Monster m){
        return m.getSpecialValue();
    }
    
    @Override
    public int computeGoldCoinsValue(ArrayList<Treasure> t) {
        int sum = 0;
        for (Treasure v : t) {
            // Las piezas de oro duplican su valor
            sum += v.getGoldCoins()*2;
        }
        return sum/1000;
    }
}
