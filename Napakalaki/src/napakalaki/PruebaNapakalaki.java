/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author fdavidcl
 * @author ncordon
 */
public class PruebaNapakalaki {
    /**
     * 
     * @param level Nivel a partir del cual se imprimen los monstruos
     * @param monsters Lista de monstruos a analizar
     */
    public static ArrayList<Monster> strongerThan(int level, ArrayList<Monster> monsters) {
        ArrayList<Monster> stronger = new ArrayList();
        
        for (Monster actual : monsters){
            
            if (actual.getLevel() > level){
                stronger.add(actual.clone());
            }
        }
        
        return stronger;
    }
    
    /**
     * 
     * @param monsters Lista de monstruos a analizar
     */
    public static ArrayList<Monster> levelTakers(ArrayList<Monster> monsters) {
        ArrayList<Monster> result = new ArrayList();
        
        for (Monster monstruo : monsters){
            BadConsequence act = monstruo.getBadConsequence();
                        
            if (act.getLevels() > 0 && act.getSpecificHiddenTreasures().isEmpty()
                && act.getSpecificVisibleTreasures().isEmpty() && !act.getDeath()
                && act.getHiddenTreasures()==0 && act.getVisibleTreasures()==0) {
                
                result.add(monstruo.clone());
            }
        }
        
        return result;
    }
    
    /**
     * 
     * @param min Mínimo número de niveles a ganar
     * @param monsters Lista de monstruos a analizar
     */
    public static ArrayList<Monster> prizeMinLevels(int min, ArrayList<Monster> monsters) {
        ArrayList<Monster> result = new ArrayList();
        
        for (Monster actual : monsters) {
            if (actual.getPrize().getLevels() >= min) {
                result.add(actual.clone());
            }
        }
        
        return result;
    }
    
    /**
     * 
     * @param monsters Lista de monstruos a mostrar
     */
    public static void displayMonsters(ArrayList<Monster> monsters, String mensaje) {
        System.out.printf("*** %s ***\n", mensaje);
        
        for (Monster actual : monsters) {
            System.out.println(actual.toString());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Prize p = new Prize(3, 4);
        //System.out.println(p.toString());
        //BadConsequence malrollo = new BadConsequence("Mortal", true);
        //System.out.println(malrollo.toString());
        //Monster nacho = new Monster("Nacho", 30, malrollo, p);
        //System.out.println(nacho.toString());
        ArrayList<Monster> monsters;
        ArrayList<TreasureKind> tv = new ArrayList();
        ArrayList<TreasureKind> to = new ArrayList();
        tv.add(TreasureKind.HELMET);
        to.add(TreasureKind.HELMET);
        monsters=new ArrayList();
        
        monsters.add(new Monster("3 Byakhees de bonanza",8,new BadConsequence
            ("Pierdes tu armadura visible y otra oculta",0,tv,to),new Prize(2,1))
        );
        to.clear();
        monsters.add(new Monster ("Chibithulhu",2, new BadConsequence
            ("Embobados con el lindo primigenio te descartas de tu casco visible",0,
            tv,to), new Prize (1,1))
        );
        tv.clear();
        tv.add(TreasureKind.SHOE);
        monsters.add(new Monster ("El sopor de Dunwich",2, new BadConsequence
            ("El primordial bostezo contagioso. Pierdes el calzado visible",0,
            tv,to), new Prize (1,1))
        );
        tv.clear();
        tv.add(TreasureKind.ONEHAND);
        to.add(TreasureKind.ONEHAND);
        monsters.add(new Monster ("Ángeles de la noche ibicenca",14, new BadConsequence
            ("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo."
                    + "Descarta 1 mano visible y 1 mano oculta",0,
            tv,to), new Prize (4,1))
        );
        tv.clear();
        to.clear();
        // Nótese que perder totalidad tesoros == perder máximo (entero) de tesoros
        monsters.add(new Monster ("El gorrón en el umbral",10, new BadConsequence
            ("Pierdes todos tus tesoros visibles",0,Integer.MAX_VALUE,0), new Prize (3,1))
        );
        tv.add(TreasureKind.HELMET);
        monsters.add(new Monster ("H.P. Munchcraft",6, new BadConsequence
            ("Pierdes la armadura visible",0,tv,to), new Prize (2,1))
        );
        monsters.add(new Monster ("Bichgooth",2, new BadConsequence
            ("Sientes bichos bajo la ropa. Descarta la armadura visible",0,tv,to),
                new Prize (1,1))
        );
        monsters.add(new Monster ("El rey de rosa",13, new BadConsequence
            ("Pierdes 5 niveles y 3 tesoros visibles",5,3,0), new Prize (4,2))
        );
        monsters.add(new Monster ("La que redacta en las sombras",3, new BadConsequence
            ("Toses los pulmones y pierdes 2 niveles",2,0,0), new Prize (1,1))
        );
        // to->vacío, tv->Helmet
        
        int min_nivel = 10;
        displayMonsters(strongerThan(min_nivel, monsters), "Monstruos con nivel mayor que" 
                + Integer.toString(min_nivel));
        
        displayMonsters(levelTakers(monsters), "Monstruos que solo restan niveles");
        
        int min_ganados = 2;
        displayMonsters(prizeMinLevels(2, monsters), "Monstruos que dan mínimo " 
                + Integer.toString(min_ganados) + " niveles");
    }   
}
