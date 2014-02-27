/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

/**
 *
 * @author fdavidcl
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prize p = new Prize(3, 4);
        System.out.println(p.toString());
        BadConsequence malrollo = new BadConsequence("Mortal", true);
        System.out.println(malrollo.toString());
    }
    
}
