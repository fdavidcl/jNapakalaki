/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TextUI;

import Game.CombatResult;
import Game.Treasure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nuwanda
 */

public class TextUI {
    private static final TextUI instance = new TextUI();
    private final Game.Napakalaki game = Game.Napakalaki.getInstance();
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private final String ESC = "\u001B";

    interface Predicate {
        boolean test(Treasure t);
    }

    private TextUI() {}

    public static TextUI getInstance() {
        return instance;
    }

    // Métodos de formato: Devuelven una string con el formato
    // aplicado a la inicial
    private String bold(String msg) {
        return ESC + "[1m" + msg + ESC + "[m";
    }

    private String invert(String msg) {
        return ESC + "[7m" + msg + ESC + "[m";
    }

    private String red(String msg) {
        return ESC + "[31m" + msg + ESC + "[m";
    }

    // Métodos de entrada: devuelven una entrada válida del tipo
    // especificado
    private String getString() {
        String input = "";
        System.out.print(" > ");

        try{
            input = in.readLine();
        }
        catch (IOException ioe) {}

        return input;
    }

    private int getInt(int min,int max) {
        int input = -1;
        boolean valid = false;

        while(!valid) {
            System.out.print('('+ Integer.toString(min)+'-'+Integer.toString(max)+") > ");
            try{
                input = Integer.parseInt(in.readLine());
                
                if (input >= min && input <= max)
                    valid = true;
            }
            catch (NumberFormatException | IOException nfe) {}
        }
        return input;
    }

    private void pause() {
        System.out.print("(Intro para continuar)");
        getString();
    }
    
    // Mostrar estado del juego
    private void display(boolean fight) {
        // Limpiamos la pantalla (funciona solo en terminal, no
        // en Netbeans)
        System.out.print(ESC + "[H" + ESC + "[2J");
        
        System.out.println(invert(bold("       Napakalaki       ")));
        System.out.println("Jugando: " + game.getCurrentPlayer().getName() + " (nivel "
                + game.getCurrentPlayer().getCombatLevel() + ")");

        if (fight) {
            System.out.println("Luchando contra " + game.getCurrentMonster().getName() +
                " (nivel " + game.getCurrentMonster().getLevel() + ")" +
                "\nSi vences obtendrás: " + game.getCurrentMonster().getPrize().toString() +
                "\nSi pierdes: " + game.getCurrentMonster().getBadConsequence());
        }
    }

    // Métodos de consulta y modificación de tesoros
    private <T> void list(ArrayList<T> l) {
        for (int i = 0; i < l.size(); ++i) {
            System.out.println("\t["+ Integer.toString(i+1) +"] " + l.get(i).toString());
        }
    }

    private void inspectTreasures() {
        Map<String,ArrayList<Game.Treasure>> treasures = new HashMap();
        treasures.put("equipados",game.getVisibleTreasures());
        treasures.put("ocultos", game.getHiddenTreasures());

        for (String type : treasures.keySet()) {
            if (treasures.get(type).isEmpty())
                System.out.println("¡No tienes tesoros " + type + '!');
            else{
                System.out.println("Tienes estos tesoros " + type + ':');
                list(treasures.get(type));
            }
        }
    }

    private ArrayList<Game.Treasure> selectTreasures(ArrayList<Game.Treasure> treasures,
        boolean visibles, Predicate condition) {
        ArrayList<Game.Treasure> result = new ArrayList();
        String type = (visibles ? "equipados" : "ocultos");

        if (!treasures.isEmpty()) {
            System.out.println(bold("¿Qué tesoros " + type + " quieres emplear?"));
            int index = 1;

            while (index > 0 && treasures.size() > 0) {
                System.out.println("Seleccionados hasta el momento: " + result.toString());
                list(treasures);
                System.out.println("\t[0] Terminar selección");

                index = getInt(0, treasures.size());
                if (index > 0)
                    if (condition.test(treasures.get(index - 1)))
                        result.add(treasures.remove(index - 1));
                    else
                        System.out.println(red("No puedes utilizar este tesoro."));
            }
        }
        else
            System.out.println("¡No tienes tesoros " + type + '!');

        return result;
    }

    // Método de consulta de resultados de combate
    private String combatResult(Game.CombatResult result) {
        String msg = "";

        switch(result) {
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
        
        return msg;
    }
    
    // Método de juego: Muestra menús e interactúa con el jugador
    public void play() {
        ArrayList<String> players = new ArrayList();
        boolean read = true, gameOver = false;
        CombatResult result;
        int option;

        System.out.println("Introduce nombre de los jugadores");
        
        // Se permiten 3 jugadores como máximo
        while (read && players.size() < 3) {
            String p = getString();
            if (p.equals("\n") || p.isEmpty())
                read = false;
            else
                players.add(p);
        }

        if (players.isEmpty() || players.size() > 3)
            throw new IllegalStateException("El número de jugadores debe estar entre 1 y 3.");

        game.initGame(players);

        while (!gameOver) {
            Game.Player player = game.getCurrentPlayer();
            
            // Pre-lucha: El jugador puede comprar niveles
            display(false);
            System.out.println("Antes de luchar puedes comprar niveles.");

            if (!game.buyLevels(selectTreasures(player.getVisibleTreasures(),true,
                    new Predicate(){public boolean test(Treasure t) {return true;}}),
                    selectTreasures(player.getHiddenTreasures(), false,
                    new Predicate(){public boolean test(Treasure t) {return true;}}))) {
                System.out.println("No puedes comprar tantos niveles");
                pause();
            }

            // Comenzar lucha
            display(true);

            result = game.combat();
            System.out.println("Resultado: " + bold(combatResult(result)));
            pause();
            
            // Post-lucha
            boolean nextTurn = false;

            if (!game.endOfGame(result)) {
                while(!nextTurn) {
                    display(false);
                    
                    // El jugador podría haber muerto tras descartarse tesoros
                    // o bien como resultado del combate
                    if (player.isDead()) {
                        System.out.println(bold("¡Has muerto!") + " Revivirás en tu "
                            + "próximo turno con nuevos tesoros.");
                        nextTurn = true;
                        pause();
                    } else {
                        // Mostramos un menú
                        System.out.println(bold("¿Qué quieres hacer? \n") +
                            " [1] Ver inventario \n" +
                            " [2] Descartar tesoro equipado \n" +
                            " [3] Descartar tesoro oculto \n" +
                                (game.nextTurnAllowed() ? 
                                    " [4] Equipar un tesoro\n [0] Seguir jugando" :
                                    " [0] Consultar mal rollo pendiente"));
                        option = getInt(0,game.nextTurnAllowed() ? 4 : 3);

                        switch(option) {
                            case 1: // Consulta de tesoros
                                inspectTreasures();
                                break;
                            case 2: // Descarte de tesoros equipados
                                selectTreasures(player.getVisibleTreasures(), true,
                                    new Predicate(){public boolean test(Treasure t) {
                                        game.discardVisibleTreasure(t);
                                        return true;
                                    }});
                                break;
                            case 3: // Descarte de tesoros ocultos
                                selectTreasures(player.getHiddenTreasures(), false,
                                    new Predicate(){public boolean test(Treasure t) {
                                        game.discardHiddenTreasure(t);
                                        return true;
                                    }});
                                break;
                            case 4: // Equipar un tesoro
                                selectTreasures(player.getHiddenTreasures(), false,
                                    new Predicate(){public boolean test(Treasure t) {
                                        return game.makeTreasureVisible(t);
                                    }});
                                break;
                            case 0: // Acción de continuar (si no hay mal rollo pendiente)
                                if (game.nextTurnAllowed())
                                    nextTurn = true;
                                else {
                                    System.out.println("Mal rollo pendiente:\n\t" + 
                                        game.getCurrentMonster().getBadConsequence().toString() +
                                        bold("\nDescarta los tesoros correspondientes para poder seguir jugando."));
                                }
                                break;
                            default:
                                System.out.println("Opción " + option + "inválida."
                                    + "Utiliza [0] para seguir jugando.");
                        }

                        if (!nextTurn)
                            pause();
                    }
                }
                
                game.nextTurn();
            }
            else {
                System.out.println(bold("¡¡¡¡ Ganador:" + player.getName() + "!!!!"));
                gameOver = true;
            }
        }
    }

    public static void main(String [ ] args) {
        getInstance().play();
    }
}
