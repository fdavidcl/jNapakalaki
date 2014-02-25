/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

import static java.lang.Integer.parseInt;

/**
 *
 * @author fdavidcl
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Necesarios 2 parámetros para la creación de un "
                    + "objeto Prize.");
            return;
        }
        Prize p = new Prize(parseInt(args[0]), parseInt(args[1]));
        System.out.println(p.getLevels() + " niveles, " + p.getTreasures() + " tesoros.");
    }
    
}
