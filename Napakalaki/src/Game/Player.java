/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.ArrayList;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.Collections;

/**
 * Clase que representa un jugador
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class Player {
    private boolean dead = true;
    private String name;
    private int level = 1;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;

    Player(String name) {
        this.name = name;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
    }

    private void bringToLife() {
        dead = false;
    }

    private void incrementLevels(int l) {
        level = min(level+l,10);
    }

    private void decrementLevels(int l) {
        level = max(level-l,1);
    }

    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }

    private void die() {
        dead = true;

        for (Treasure t : visibleTreasures)
            CardDealer.getInstance().giveTreasureBack(t);

        visibleTreasures.clear();

        for (Treasure t : hiddenTreasures)
            CardDealer.getInstance().giveTreasureBack(t);

        hiddenTreasures.clear();
    }

    private void discardNecklaceIfVisible() {
        for (Treasure t : visibleTreasures) {
            if (t.getType() == TreasureKind.NECKLACE) {
                CardDealer.getInstance().giveTreasureBack(t);

                break;
            }
        }
    }
    private void dieIfNoTreasures() {
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            die();
    }

    private int computeGoldCoinsValue(ArrayList<Treasure> t) {
        int sum = 0;
        for (Treasure v : t) {
            sum += v.getGoldCoins();
        }
        return sum/1000;
    }

    private boolean canIBuyLevels(int l) {
        return (level + l) < 10;
    }

    private void discardTreasure(ArrayList<Treasure>list,Treasure t,boolean visible) {
        if (list.remove(t)) {

            if (!validState())
                if(visible)
                    pendingBadConsequence.substractVisibleTreasure(t);
                else
                    pendingBadConsequence.substractHiddenTreasure(t);

            CardDealer.getInstance().giveTreasureBack(t);
        }

        dieIfNoTreasures();
    }
    public void applyPrize(Prize p) {
        incrementLevels(p.getLevels());

        for (int i=0; i<min(p.getTreasures(),4-hiddenTreasures.size());i++) {
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        }
    }

    public CombatResult combat(Monster m) {
        CombatResult result;

        if (getCombatLevel() > m.getLevel()) {
            Prize prize = m.getPrize();
            applyPrize(prize);
            result = (level < 10 ? CombatResult.WIN : CombatResult.WINANDWINGAME);
        }
        else if (Dice.getInstance().nextNumber() < 5) {
            BadConsequence bad = m.getBadConsequence();
            if (bad.kills()) {
                die();
                result = CombatResult.LOSEANDDIE;
            }
            else{
                applyBadConsequence(bad);
                result = CombatResult.LOSE;
            }
        }
        else{
            result = CombatResult.LOSEANDESCAPE;
        }

        discardNecklaceIfVisible();
        return result;
    }

    public void applyBadConsequence(BadConsequence bad) {
        decrementLevels (bad.getLevels());

        BadConsequence pendingBad = bad.adjustToFitTreasureLists (visibleTreasures,hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }

    public boolean makeTreasureVisible(Treasure t) {
        boolean can;

        if (can = canMakeTreasureVisible(t)) {
            visibleTreasures.add(t);
            discardHiddenTreasure(t);
        }

        return can;
    }

    public boolean canMakeTreasureVisible(Treasure t) {
        ArrayList <TreasureKind> vt = new ArrayList();

        for (Treasure e : visibleTreasures)
            vt.add(e.getType());

        if (t.getType() == TreasureKind.ONEHAND)
            return (!vt.contains(TreasureKind.BOTHHANDS) && (Collections.frequency(vt, TreasureKind.ONEHAND)<2));
        else if (t.getType() == TreasureKind.BOTHHANDS)
            return (!vt.contains(TreasureKind.BOTHHANDS) && !vt.contains(TreasureKind.ONEHAND));
        else
            return !vt.contains(t.getType());
    }

    public void discardVisibleTreasure(Treasure t) {
        discardTreasure(visibleTreasures, t, true);
    }

    public void discardHiddenTreasure(Treasure t) {
        discardTreasure(hiddenTreasures, t, false);
    }

    public boolean buyLevels(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        ArrayList <Treasure> visible = (ArrayList <Treasure>) v.clone();
        ArrayList <Treasure> hidden = (ArrayList <Treasure>) h.clone();

        int levels = computeGoldCoinsValue(v) + computeGoldCoinsValue(h);
        boolean canI;

        if (canI=canIBuyLevels(levels)) {
            incrementLevels(levels);

            for (Treasure t : visible)
                discardVisibleTreasure(t);
            for (Treasure t : hidden)
                discardHiddenTreasure(t);
        }
        return canI;
    }

    public boolean validState() {
        return pendingBadConsequence == null || pendingBadConsequence.isEmpty();
    }

    public void initTreasures() {
        bringToLife();
        int number = Dice.getInstance().nextNumber();

        if (number == 1)
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        else{
            int limit = (number < 6 ? 2 : 3);

            for (int i=0; i<limit; ++i)
                hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        }
    }

    public boolean hasVisibleTreasures() {
        return !visibleTreasures.isEmpty();
    }

    public boolean isDead() {
        return dead;
    }

    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        int sum = this.level;
        boolean usingNecklace = false;
        
        for (Treasure t : visibleTreasures)
            if (t.getType() == TreasureKind.NECKLACE)
                usingNecklace = true;

        if (usingNecklace)
            for (Treasure t : visibleTreasures)
                sum += t.getMaxBonus();
        else
            for (Treasure t:visibleTreasures)
                sum += t.getMinBonus();

        return sum;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return (ArrayList<Treasure>) hiddenTreasures.clone();
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return (ArrayList<Treasure>) visibleTreasures.clone();
    }
}
