/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;
import java.util.ArrayList;
import java.util.Random;
/**
 * Clase del juego principal
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class Napakalaki {
    private Monster currentMonster;

    private Player currentPlayer;

    private int currentPlayerIndex;

    private ArrayList<Player> players;

    private static final Napakalaki instance = new Napakalaki();

    private Napakalaki() {
        players = new ArrayList();
    }

    private void initPlayers (ArrayList<String> names) {
        for (String p: names) {
            players.add(new Player(p));
        }
    }

    private Player nextPlayer() {
        currentPlayerIndex += 1;
        currentPlayerIndex %= players.size();
        return players.get(currentPlayerIndex);
    }

    public static Napakalaki getInstance() {
        return instance;
    }

    public CombatResult combat() {
        CombatResult result = currentPlayer.combat(currentMonster);
        CardDealer.getInstance().giveMonsterBack(currentMonster);
        return result;
    }

    public void discardVisibleTreasure (Treasure t) {
        currentPlayer.discardVisibleTreasure(t);
    }

    public void discardHiddenTreasure (Treasure t) {
        currentPlayer.discardHiddenTreasure(t);
    }

    public boolean makeTreasureVisible (Treasure t) {
        return currentPlayer.makeTreasureVisible(t);
    }

    public boolean buyLevels (ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        return currentPlayer.buyLevels(visible,hidden);
    }

    public void initGame (ArrayList<String> players) {
        CardDealer.getInstance().initCards();
        initPlayers(players);
        currentPlayerIndex = new Random().nextInt(players.size());
        currentPlayer = this.players.get(currentPlayerIndex);
        nextTurn();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public boolean canMakeTreasureVisible(Treasure t) {
        return currentPlayer.canMakeTreasureVisible(t);
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return currentPlayer.getVisibleTreasures();
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return currentPlayer.getHiddenTreasures();
    }

    @SuppressWarnings("empty-statement")
    public boolean nextTurn() {
        // Consultar: la función debe devolver stateOK??
        boolean stateOK = nextTurnAllowed();

        if (stateOK) {
            currentMonster = CardDealer.getInstance().nextMonster();
            currentPlayer = nextPlayer();

            if (currentPlayer.isDead())
                currentPlayer.initTreasures();
        }
        return stateOK;
    }

    public boolean nextTurnAllowed() {
        return currentPlayer.validState();
    }

    public boolean endOfGame(CombatResult result) {
        return result == CombatResult.WINANDWINGAME;
    }
}
