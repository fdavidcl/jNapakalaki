/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

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
    private static final Napakalaki game = Napakalaki.getInstance();
    
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
    
    private <T> void list(ArrayList<T> l){
        System.out.print("\n[");
        for (T t : l){
            System.out.print(t.toString() + ' ');
        }
        System.out.print("]\n");
    }
    
    // Esto funcionará???
    private void inspectTreasures(){
        Player player = game.getCurrentPlayer();
        
        Map<String,ArrayList<Treasure>> treasures = new HashMap();
        treasures.put("visibles",game.getVisibleTreasures());
        treasures.put("hidden", game.getHiddenTreasures());
        
        for (String type : treasures.keySet()){
            if (treasures.get(type).isEmpty())
                System.out.println("¡No tienes tesoros" + type + '!');
            else{
                System.out.println("Tienes estos tesoros:");
                list(treasures.get(type));
            }
        }       
    }
    
    
    
    
    
    public void play(){
        // FUNCIONA MUAJAJAJAJAJ
        ArrayList<Integer> l =new ArrayList();
        l.add(5);
        l.add(3);
        l.add(2);
        list(l);
        
    }
    
    public static void main(String [ ] args){ 
        getInstance().play();
    }
}        
