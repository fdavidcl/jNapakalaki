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
     */
    public static void strongerThan(int level, ArrayList<Monster> monsters) {
        System.out.println("*** Monstruos de nivel superior a " + 
            Integer.toString(level) + "***");
            
        for (int i=0; i < monsters.size(); ++i){
            Monster act = monsters.get(i);
            
            if (act.getLevel() > level){
                System.out.println(act.toString()+ "\n\t" + act.getPrize().toString()
                    + "\n\t" + act.getBadConsequence().toString());
            }
        }
    }
    
    public static void levelTakers(ArrayList<Monster> monsters) {
        System.out.println("*** Monstruos que sólo restan niveles ***");
        
        for (int i=0; i < monsters.size(); ++i){
            Monster monstruo = monsters.get(i);
            BadConsequence act= monstruo.getBadConsequence();
                        
            if (act.getLevels() > 0 && act.getSpecificHiddenTreasures().isEmpty()
                && act.getSpecificVisibleTreasures().isEmpty() && !act.getDeath()
                && act.getHiddenTreasures()==0 && act.getVisibleTreasures()==0){
                
                System.out.println(monstruo.toString() + "\n\t" + 
                        monstruo.getPrize().toString() + "\n\t" + 
                        monstruo.getBadConsequence().toString());
            }
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
        
        strongerThan(10, monsters);
        levelTakers(monsters);
    }   
}
