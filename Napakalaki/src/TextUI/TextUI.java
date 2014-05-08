/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TextUI;

import Game.CombatResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nuwanda
 */

public class TextUI {
    private static final TextUI instance = new TextUI();
    private static final Game.Napakalaki game = Game.Napakalaki.getInstance();
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private TextUI(){}
    
    public static TextUI getInstance(){
        return instance;
    }
    
    private int getInt(int min,int max){
        int input = -1;
        boolean valid = false;
        
        while(!valid){
            System.out.print('('+ Integer.toString(min)+'-'+Integer.toString(max)+") > ");
            try{          
                input = Integer.parseInt(in.readLine());
                
                if (input >= min && input <= max)
                    valid = true;
            }
            catch (NumberFormatException | IOException nfe){}         
        }
        return input;
    }

    private String getString(){
        String input = "";
        System.out.print(" > ");
        
        try{
            input = in.readLine();
        }
        catch (IOException ioe){}
        
        return input;
    }
    
    private Character getChar(ArrayList<Character> allowed){
        Character input = ' ';
        String separador;
        boolean valid = false;
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
                input = new Character((char)in.read());
                // Leemos el resto de la línea
                in.readLine();
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
    
    private void display(boolean fight){
        System.out.println("       Napakalaki       ");
        System.out.println("Jugando " + game.getCurrentPlayer().getName() + "(nivel " 
                + game.getCurrentPlayer().getCombatLevel() + ")");
        
        if (fight){
            // Revisar esta línea para que haya coherencia con lo entregado en Ruby
            System.out.print("Luchando contra " + game.getCurrentMonster()
                + "\nSi vences obtendrás: " + game.getCurrentMonster().getPrize().toString()
                + "\nSi pierdes: " + game.getCurrentMonster().getBadConsequence());
        }
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
        ArrayList<String> players = new ArrayList();
        boolean read = true, fight = false, gameOver = false;
        Game.Player player = null;
        CombatResult result;
        int option;
        
        System.out.println("Introduce nombre de los jugadores: ");
        while(read){
            String p = getString();
            if (p.equals("\n") || p.isEmpty())
                read = false;
            else
                players.add(p);
        }
        
        if (players.isEmpty() || players.size() > 3)
            throw new IllegalStateException("El número de jugadores debe estar entre 1 y 3.");
        
        game.initGame(players);
        /*
        while (!gameOver){
            player = game.getCurrentPlayer();
            
            display (fight);
            System.out.println("Antes de luchar puedes comprar niveles.");
            
            if (game.buyLevels(treasureSelect(player.getVisibleTreasures(),true),
                treasureSelect(player.getHiddenTreasures(), false)))
                System.out.println("Has comprado los niveles");
            else
                System.out.println("No puedes comprar tantos niveles");
            
            display (fight = true);
            
            result = game.combat();
            printCombatResult(result);
            pause();
            
            if (!game.endOfGame(result)){
                while(fight){
                    display(!fight);
                    
                    System.out.println("¿Qué quieres hacer? \n" +
                        " [1] Ver inventario \n" +
                        " [2] Descartar tesoro equipado \n" +
                        " [3] Descartar tesoro oculto \n" +
                        " [4] Equipar un tesoro\n" +
                        "*[0] Seguir jugando\n");
                    option = getInt(0,4);
                   
                    switch(option){
                        case 1:
                            inspectTreasures();
                            break;
                        case 2:
                            discardTreasure(player.getVisibleTreasures(), true);
                            break;
                        case 3:
                            discardTreasure(player.getHiddenTreasures(), true);
                            break;
                        case 4:
                            makeVisible(player.getHiddenTreasures());
                            break;
                        case 0:
                            fight = false;
                            break;
                        default:
                            System.out.println("Opctión " + option + "inválida."
                                + "Utiliza [0] para seguir jugando.");
                    }
                    
                    if (fight)
                        pause();
                    
                    while (!game.nextTurn()){
                        // mal rollo pendiente
                    }
                }
            }
            else{
                System.out.println("¡¡¡¡ Ganador:" + game.getCurrentPlayer().getName() + "!!!!");
                gameOver = true;
            }
        }*/
    }
    
    public static void main(String [ ] args){ 
        getInstance().play();
    }
}        
