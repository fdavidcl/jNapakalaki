/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.Collections;
import java.util.ArrayList;

/**
 * Clase singleton que reparte y gestiona las cartas
 * @author Francisco David Charte Luque
 * @author Ignacio Cordón Castillo
 */
public class CardDealer {
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Cultist> unusedCultists;
    private static final CardDealer instance = new CardDealer();

    private CardDealer() {
        usedMonsters = new ArrayList();
        unusedMonsters = new ArrayList();
        usedTreasures = new ArrayList();
        unusedTreasures = new ArrayList();
        unusedCultists = new ArrayList();
    }

    private void initTreasureCardDeck() {
        unusedTreasures.add(new Treasure ("¡Sí mi amo!",0,4,7,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("Botas de investigación",600,3,4,TreasureKind.SHOE));
        unusedTreasures.add(new Treasure ("Capucha de Cthulhu",500,3,5,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure ("A prueba de babas verdes",400,3,5,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 200, 1, 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 300, 2, 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La fuerza de Mr.T", 1000, 0, 0, TreasureKind.NECKLACE));
        unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycón", 300, 3, 5, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 200, 0, 1, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapatilla deja-amigos", 500, 0, 1, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));
    }

    private void initMonsterCardDeck() {
        ArrayList<TreasureKind> tv = new ArrayList();
        ArrayList<TreasureKind> to = new ArrayList();
        tv.add(TreasureKind.ARMOR);
        to.add(TreasureKind.ARMOR);

        unusedMonsters.add(new Monster("3 Byakhees de bonanza",8,new BadConsequence
            ("Pierdes tu armadura visible y otra oculta",0,tv,to),new Prize(2,1))
        );

        tv.clear();
        to.clear();
        tv.add(TreasureKind.HELMET);
        unusedMonsters.add(new Monster ("Chibithulhu",2, new BadConsequence
            ("Embobados con el lindo primigenio te descartas de tu casco visible",0,
            tv,to), new Prize (1,1))
        );
        tv.clear();
        tv.add(TreasureKind.SHOE);
        unusedMonsters.add(new Monster ("El sopor de Dunwich",2, new BadConsequence
            ("El primordial bostezo contagioso. Pierdes el calzado visible",0,
            tv,to), new Prize (1,1))
        );
        tv.clear();
        tv.add(TreasureKind.ONEHAND);
        to.add(TreasureKind.ONEHAND);
        unusedMonsters.add(new Monster ("Ángeles de la noche ibicenca",14, new BadConsequence
            ("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo."
                    + "Descarta 1 mano visible y 1 mano oculta",0,
            tv,to), new Prize (4,1))
        );
        tv.clear();
        to.clear();
        // Nótese que perder totalidad tesoros == -1
        unusedMonsters.add(new Monster ("El gorrón en el umbral",10, new BadConsequence
            ("Pierdes todos tus tesoros visibles",0,-1,0), new Prize (3,1))
        );
        tv.add(TreasureKind.ARMOR);
        unusedMonsters.add(new Monster ("H.P. Munchcraft",6, new BadConsequence
            ("Pierdes la armadura visible",0,tv,to), new Prize (2,1))
        );
        unusedMonsters.add(new Monster ("Bichgooth",2, new BadConsequence
            ("Sientes bichos bajo la ropa. Descarta la armadura visible",0,tv,to),
                new Prize (1,1))
        );
        unusedMonsters.add(new Monster ("El rey de rosa",13, new BadConsequence
            ("Pierdes 5 niveles y 3 tesoros visibles",5,3,0), new Prize (4,2))
        );
        unusedMonsters.add(new Monster ("La que redacta en las sombras",3, new BadConsequence
            ("Toses los pulmones y pierdes 2 niveles",2,0,0), new Prize (1,1))
        );
        unusedMonsters.add(new Monster ("Los hondos verdes",7, new BadConsequence
            ("Estos monstruos resultan bastante superficiales y te aburren mortalmente."
            + "Estás muerto",true), new Prize (2,1))
        );
        unusedMonsters.add(new Monster ("Semillas Cthulhu",4, new BadConsequence
            ("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2), new Prize (2,1))
        );
        tv.clear();
        tv.add(TreasureKind.ONEHAND);
        unusedMonsters.add(new Monster ("Dameargo",1, new BadConsequence
            ("Te intentas escaquear. Pierdes una mano visible",0,tv,to),
            new Prize (2,1))
        );
        unusedMonsters.add(new Monster ("Pollipólipo volante",3, new BadConsequence
            ("Da mucho asquito. Pierdes 3 niveles",3,0,0), new Prize (1,1))
        );
        unusedMonsters.add(new Monster ("Yskhtihyssg-Goth",12, new BadConsequence
            ("No le hace gracia que pronuncien mal su nombre. Estás muerto",true),
            new Prize (3,1))
        );
        unusedMonsters.add(new Monster ("Familia Feliz",1, new BadConsequence
            ("La familia te atrapa. Estás muerto",true), new Prize (4,1))
        );
        tv.clear();
        tv.add(TreasureKind.BOTHHANDS);
        unusedMonsters.add(new Monster ("Roboggoth",8, new BadConsequence
            ("La quinta directiva primaria te obliga a perder 2 niveles y un "
            + "tesoro, 2 manos visible",0,tv,to), new Prize (2,1))
        );
        tv.clear();
        tv.add(TreasureKind.HELMET);
        unusedMonsters.add(new Monster ("El espia ciego",4, new BadConsequence
            ("Te asusta en la noche. Pierdes un casco visible",0,tv,to),
            new Prize (1,1))
        );
        unusedMonsters.add(new Monster ("El lenguas",20, new BadConsequence
            ("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",
            2,5,0), new Prize (1,1))
        );
        tv.clear();
        tv.add(TreasureKind.BOTHHANDS);
        tv.add(TreasureKind.ONEHAND);
        tv.add(TreasureKind.ONEHAND);
        to.clear();
        unusedMonsters.add(new Monster ("Bicéfalo",20, new BadConsequence
            ("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros "
            + "visibles de las manos",3, tv, to), new Prize (1,1))
        );
        tv.clear();
        to.clear();

        // Sectarios
        tv.add(TreasureKind.ONEHAND);
        unusedMonsters.add(new Monster ("El mal indecible impronunciable",10, new BadConsequence
            ("Pierdes 1 mano visible",0, tv, to), new Prize (3,1),-2)
        );
        tv.clear();
        unusedMonsters.add(new Monster ("Testigos Oculares", 6, new BadConsequence
            ("Pierdes tus tesoros visibles. Jajaja",0,-1,0), new Prize (2,1),2)
        );
        unusedMonsters.add(new Monster ("El gran cthulhu", 20, new BadConsequence
            ("Hoy no es tu día de suerte. Mueres",true), new Prize (2,5),4)
        );
        unusedMonsters.add(new Monster ("Serpiente Político", 8, new BadConsequence
            ("Tu gobierno te recorta 2 niveles",2,0,0), new Prize (2,1),-2)
        );

        tv.clear();
        to.clear();
        tv.add(TreasureKind.HELMET);
        tv.add(TreasureKind.ARMOR);
        to.add(TreasureKind.ONEHAND);
        to.add(TreasureKind.ONEHAND);
        to.add(TreasureKind.ONEHAND);
        to.add(TreasureKind.ONEHAND);
        to.add(TreasureKind.BOTHHANDS);
        to.add(TreasureKind.BOTHHANDS);
        to.add(TreasureKind.BOTHHANDS);
        to.add(TreasureKind.BOTHHANDS);
        unusedMonsters.add(new Monster ("Felpuggoth",2, new BadConsequence
            ("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",
                0, tv, to), new Prize (1,1), 5)
        );

        unusedMonsters.add(new Monster("Shoggoth", 16, new BadConsequence(
            "Pierdes 2 niveles", 2, 0, 0), new Prize(4, 2), -4));

        unusedMonsters.add(new Monster("Lolitagooth", 2, new BadConsequence(
            "Pintalabios negro. Pierdes 2 niveles", 2, 0, 0), new Prize(1, 1), 3));
    }

    private void initCultistCardDeck() {
        // Añadir cartas sectarias
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 1));
    }

    private void shuffleTreasures() {
        Collections.shuffle(unusedTreasures);
    }

    private void shuffleMonsters() {
        Collections.shuffle(unusedMonsters);
    }

    private void shuffleCultists() {
        Collections.shuffle(unusedCultists);
    }

    public static CardDealer getInstance() {
        return instance;
    }

    public Treasure nextTreasure() {
        Treasure result = unusedTreasures.remove(0);

        if (unusedTreasures.isEmpty()) {
            unusedTreasures = (ArrayList<Treasure>)usedTreasures.clone();
            usedTreasures.clear();
            shuffleTreasures();
        }

        return result;
    }

    public Monster nextMonster() {
        Monster result = unusedMonsters.remove(0);

        if (unusedMonsters.isEmpty()) {
            unusedMonsters = (ArrayList<Monster>)usedMonsters.clone();
            usedMonsters.clear();
            shuffleMonsters();
        }

        return result;
    }

    public Cultist nextCultist() {
        Cultist result = unusedCultists.remove(0);

        return result;
    }

    public void giveTreasureBack(Treasure t) {
        usedTreasures.add(t);
    }

    public void giveMonsterBack(Monster m) {
        usedMonsters.add(m);
    }

    public void initCards() {
        initMonsterCardDeck();
        shuffleMonsters();
        initTreasureCardDeck();
        shuffleTreasures();
        initCultistCardDeck();
        shuffleCultists();
    }
}
