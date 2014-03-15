/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;
import java.util.ArrayList;
/**
 * Clase para el programa principal
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class PruebaNapakalaki {
    /**
     * Devuelve los monstruos con nivel mayor que el especificado
     * @param level Nivel a partir del cual se imprimen los monstruos
     * @param monsters Lista de monstruos a analizar
     * @return Monstruos en la lista con nivel mayor a `level`
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
     * Devuelve los monstruos que solo restan niveles
     * @param monsters Lista de monstruos a analizar
     * @return Monstruos de la lista que solo restan niveles
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
     * Halla los monstruos que aportan un mínimo de niveles
     * @param min Mínimo número de niveles a ganar
     * @param monsters Lista de monstruos a analizar
     * @return Monstruos cuyo buen rollo da mínimo `min` niveles
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
     * Devuelve los monstruos que restan tesoros del tipo especificado
     * @param kind Tipo de tesoros
     * @param monsters Lista de monstruos a analizar
     * @return Monstruos cuyo mal rollo incluye tesoros de tipo `kind`
     */
    public static ArrayList<Monster> treasureKindTakers(TreasureKind kind, ArrayList<Monster> monsters){
        ArrayList<Monster> result = new ArrayList();
        
        for(Monster actual : monsters){
            BadConsequence bad=actual.getBadConsequence();
            
            if (bad.getSpecificHiddenTreasures().contains(kind) ||
                bad.getSpecificVisibleTreasures().contains(kind)){
                result.add(actual.clone());
            }
        }
        
        return result;
    }
    /**
     * Muestra todos los monstruos de una lista por pantalla
     * @param monsters Lista de monstruos a mostrar
     * @param mensaje Encabezado de la lista de monstruos
     */
    public static void displayMonsters(ArrayList<Monster> monsters, String mensaje) {
        System.out.printf("*** %s ***\n", mensaje);
        
        for (Monster actual : monsters) {
            System.out.println(actual.toString());
        }
    }
    
    /**
     * Programa principal
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Prize p = new Prize(3, 4);
        System.out.println(p.toString());
        BadConsequence malrollo = new BadConsequence("Mortal", true);
        System.out.println(malrollo.toString());
        Monster nacho = new Monster("Nacho", 30, malrollo, p);
        System.out.println(nacho.toString());
        */
        ArrayList<Monster> monsters;
        ArrayList<TreasureKind> tv = new ArrayList();
        ArrayList<TreasureKind> to = new ArrayList();
        tv.add(TreasureKind.ARMOR);
        to.add(TreasureKind.ARMOR);
        monsters=new ArrayList();
        
        
        monsters.add(new Monster("3 Byakhees de bonanza",8,new BadConsequence
            ("Pierdes tu armadura visible y otra oculta",0,tv,to),new Prize(2,1))
        );
        tv.clear();
        to.clear();
        tv.add(TreasureKind.HELMET);
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
            ("Pierdes todos tus tesoros visibles",0,BadConsequence.TODOS,0), new Prize (3,1))
        );
        tv.add(TreasureKind.ARMOR);
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
        monsters.add(new Monster ("Los hondos verdes",7, new BadConsequence
            ("Estos monstruos resultan bastante superficiales y te aburren mortalmente."
            + "Estás muerto",true), new Prize (2,1))
        );
        monsters.add(new Monster ("Semillas Cthulhu",4, new BadConsequence
            ("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2), new Prize (2,1))
        );
        tv.clear();
        tv.add(TreasureKind.ONEHAND);
        monsters.add(new Monster ("Dameargo",1, new BadConsequence
            ("Te intentas escaquear. Pierdes una mano visible",0,tv,to), 
            new Prize (2,1))
        );
        monsters.add(new Monster ("Pollipólipo volante",3, new BadConsequence
            ("Da mucho asquito. Pierdes 3 niveles",3,0,0), new Prize (1,1))
        );
        monsters.add(new Monster ("Yskhtihyssg-Goth",12, new BadConsequence
            ("No le hace gracia que pronuncien mal su nombre. Estás muerto",true),
            new Prize (3,1))
        );
        monsters.add(new Monster ("Familia Feliz",1, new BadConsequence
            ("La familia te atrapa",true), new Prize (4,1))
        );
        tv.clear();
        tv.add(TreasureKind.BOTHHANDS);
        monsters.add(new Monster ("Roboggoth",8, new BadConsequence
            ("La quinta directiva primaria te obliga a perder 2 niveles y un "
            + "tesoro, 2 manos visible",0,tv,to), new Prize (2,1))
        );
        tv.clear();
        tv.add(TreasureKind.HELMET);
        monsters.add(new Monster ("El espia ciego",3, new BadConsequence
            ("Te asusta en la noche. Pierdes un casco visible",4,tv,to), 
            new Prize (1,1))
        );
        monsters.add(new Monster ("El lenguas",20, new BadConsequence
            ("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",
            2,5,0), new Prize (1,1))
        );
        tv.clear();
        tv.add(TreasureKind.BOTHHANDS);
        monsters.add(new Monster ("Bicéfalo",20, new BadConsequence
            ("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros"
            + "visibles de las manos",3,tv,to), new Prize (1,1))
        );

        int min_nivel = 10;
        displayMonsters(strongerThan(min_nivel, monsters), "Monstruos con nivel mayor que " 
                + Integer.toString(min_nivel));
        
        displayMonsters(levelTakers(monsters), "Monstruos que solo restan niveles");
        
        int min_ganados = 2;
        displayMonsters(prizeMinLevels(2, monsters), "Monstruos que dan mínimo" 
                + Integer.toString(min_ganados) + " niveles");
        
        displayMonsters(treasureKindTakers(TreasureKind.ARMOR, monsters), 
                "Monstruos que quitan alguna armadura");
    }   
}
