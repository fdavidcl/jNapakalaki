/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TextUI;

import Game.CombatResult;
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

/**
 *
 * @author nuwanda
 */

public class TextUI {
    private static final TextUI instance = new TextUI();
    private static final Game.Napakalaki game = Game.Napakalaki.getInstance();
    
    private TextUI(){}
    
    public static TextUI getInstance(){
        return instance;
    }
    
    private int getInt(int min,int max){
        int input = -1;
        boolean valid = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(!valid){
            System.out.print('('+ Integer.toString(min)+'-'+Integer.toString(max)+") > ");
            try{          
                input = Integer.parseInt(br.readLine());
                
                if (input >= min && input <= max)
                    valid = true;
            }
            catch (NumberFormatException | IOException nfe){}         
        }
        return input;
    }

    private String getString(){
        String input = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(" > ");
        
        try{
            input = br.readLine();
        }
        catch (IOException ioe){}
        
        return input;
    }
    
    private Character getChar(ArrayList<Character> allowed){
        Character input = ' ';
        String separador;
        boolean valid = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<allowed.size(); ++i)
            allowed.set(i,Character.toUpperCase(allowed.get(i)));
        
        while (!valid){
            separador = "/";
            for (int i=0; i<allowed.size(); ++i){
                if (i == allowed.size()-1)
                    separador = " > ";
                System.out.print(allowed.get(i) + separador);
            }
            try{
                input = new Character((char)br.read());
                // Leemos el resto de la línea
                br.readLine();
                if (allowed.contains(input))
                    valid = true;
            }
            catch (IOException ioe){}
        }
        return input;
    }
    
    private void pause(){
        System.out.print("Intro para continuar");
        getString();
    }
    
    private <T> void list(ArrayList<T> l, boolean indexed){
        System.out.print("\n[ ");
        for (int i=0; i<l.size(); ++i){
            if (indexed)
                System.out.print('['+ Integer.toString(i+1) +']');
            System.out.print(l.get(i).toString() + ' ');
        }
        System.out.print("]\n");
    }
    
    // Esto funcionará???
    private void inspectTreasures(){
        Game.Player player = game.getCurrentPlayer();
        
        Map<String,ArrayList<Game.Treasure>> treasures = new HashMap();
        treasures.put("visibles",game.getVisibleTreasures());
        treasures.put("hidden", game.getHiddenTreasures());
        
        for (String type : treasures.keySet()){
            if (treasures.get(type).isEmpty())
                System.out.println("¡No tienes tesoros" + type + '!');
            else{
                System.out.println("Tienes estos tesoros:");
                list(treasures.get(type), false);
            }
        }       
    }
    
    private void discardTreasure(ArrayList<Game.Treasure> treasures, boolean visibles){
        String type = (visibles ? "visibles" : "ocultos");
        
        if (treasures.isEmpty())
            System.out.println("¡No tienes tesoros " + type + '!');
        else{
            System.out.println("Tesoros " + type + ':');
            list (treasures,true);
            int i = getInt(1, treasures.size()) - 1;
            
            if (visibles)
                game.discardVisibleTreasure(treasures.get(i));
            else
                game.discardHiddenTreasure(treasures.get(i));
        }
    }
    
    private ArrayList<Game.Treasure> treasureSelect(ArrayList<Game.Treasure> treasures, boolean visibles){
        ArrayList<Game.Treasure> result = new ArrayList();
        String type = (visibles ? "visibles" : "ocultos");
        
        if (!treasures.isEmpty()){
            System.out.println("¿Qué tesoros " + type + " quieres emplear?");
            int index = 1;
                    
            while (index > 0){
                System.out.println("Seleccionados hasta el momento: ");
                list(result, false);
                System.out.println("\t [0] Terminar selección");
                
                index = getInt(0, treasures.size());
                if (index > 0)
                    result.add(treasures.remove(index - 1));
            }        
        }
        else
            System.out.println("¡No tienes tesoros " + type + '!');
        
        return result;
    }
    
    private void makeVisible(ArrayList<Game.Treasure> treasures){
        if (treasures.isEmpty())
            System.out.println("\t ¡No dispones de tesoros para equipar!");
        else{
            list(treasures,true);
            System.out.print("\t Tesoro a equipar: ");
            int i = getInt(1, treasures.size());
            
            if (!game.makeTreasureVisible(treasures.get(i)))
                System.out.println("\t No puedes hacer visible este tesoro");
        }
    }
    
    private void printCombatResult(Game.CombatResult result){
        System.out.print("\t ---> ");
        String msg = "";
        
        switch(result){
            case WINANDWINGAME:
                msg = "Has ganado el juego";
                break;
            case WIN:
                msg = "Has ganado tu combate";
                break;
            case LOSE:
                msg = "Has perdido tu combate, tienes que cumplir un mal rollo";
                break;
            case LOSEANDESCAPE:
                msg = "Has perdido tu combate, pero has escapado a tiempo";
                break;
            case LOSEANDDIE:
                msg = "Has perdido tu combate, y el monstruo te ha matado";
                break;
        }
        System.out.print(msg + '\n');
    }
    
    public void play(){
        // FUNCIONA MUAJAJAJAJAJ
        ArrayList<Integer> l =new ArrayList();
        l.add(5);
        l.add(3);
        l.add(2);
        l.add(4);
        list(l,true);        
        printCombatResult(CombatResult.WINANDWINGAME);
    }
    
    public static void main(String [ ] args){ 
        getInstance().play();
    }
}        
