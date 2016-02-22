/**
 * Created by zoom3 on 02/02/2016.
 */
public class Application {

    public static void main(String[] args){

        /* Création des automates */
        Automate automate_contenant_root = new Automate("root");
        Automate premier_sous_automate_de_root = new Automate("Génération1");
        Automate premier_sous_automate_du_premier_filsEtat_de_root = new Automate("Génération 2 1");
        Automate premier_sosu_automate_du_deuxieme_filsEtat_de_root = new Automate("Génération 2 2");

        AutomateObserver automateObserver = new AutomateObserver();
        automate_contenant_root.addObserver(automateObserver);
        premier_sous_automate_de_root.addObserver(automateObserver);
        premier_sous_automate_du_premier_filsEtat_de_root.addObserver(automateObserver);
        premier_sosu_automate_du_deuxieme_filsEtat_de_root.addObserver(automateObserver);

        /* Création des états */
        Etat root = new Etat(automate_contenant_root,"A",true,false);
        Etat root2 = new Etat(automate_contenant_root, "B", false, true);
        Etat g1f1 = new Etat(premier_sous_automate_de_root,"C",true,false);
        Etat g1f2 = new Etat(premier_sous_automate_de_root,"D",false,true);
        Etat g1f3 = new Etat(premier_sous_automate_de_root,"E",false,true);
        Etat g2f1 = new Etat(premier_sous_automate_du_premier_filsEtat_de_root,"F",true,true);
        Etat g2f2 = new Etat(premier_sosu_automate_du_deuxieme_filsEtat_de_root,"G",true,true);

        /* Création des transitions */

        Transition t1 = new Transition(g1f1,g1f2, new Label("a"));
        Transition t2 = new Transition(g1f1,g1f3, new Label("b"));
        Transition t4 = new Transition(g1f2,g1f3, new Label("a"));
        Transition t3 = new Transition(root,root2, new Label("b"));

        /* Ajout des états */

        automate_contenant_root.ajouterEtat(root);
        automate_contenant_root.ajouterEtat(root2);
        root.ajouterSousAutomate(premier_sous_automate_de_root);

        premier_sous_automate_de_root.ajouterEtat(g1f1);
        premier_sous_automate_de_root.ajouterEtat(g1f2);
        premier_sous_automate_de_root.ajouterEtat(g1f3);

        g1f1.ajouterSousAutomate(premier_sous_automate_du_premier_filsEtat_de_root);
        premier_sous_automate_du_premier_filsEtat_de_root.ajouterEtat(g2f1);

        g1f2.ajouterSousAutomate(premier_sosu_automate_du_deuxieme_filsEtat_de_root);
        premier_sosu_automate_du_deuxieme_filsEtat_de_root.ajouterEtat(g2f2);


        /* On ajoute un observer sur les transitions */

        premier_sous_automate_de_root.ajouterTransition(t1);
        premier_sous_automate_de_root.ajouterTransition(t2);
        premier_sous_automate_de_root.ajouterTransition(t4);
        automate_contenant_root.ajouterTransition(t3);


        /*String r = automate_contenant_root.toString();
        System.out.print(r);*/

        // Cas valide

        System.out.println("-----Test 1--- toString");
        System.out.println(automate_contenant_root.toString());
        System.out.println("\n-----Test 2--- vérification de la validité de l'automate");
        Visitor visitor = new VisitorValidateAutomate();
        if((boolean) automate_contenant_root.accepter(visitor)){
            System.out.println("Automates et ses sous automates valides.");
        }else{
            System.out.println("L'automate OU l'un de ses sous automates est invalide.");
        }


        /* Modification pour rendre l'automate invalide */
        System.out.println("\n-----Test 3--- deux états de même nom");
        root2.nom="A";
        if((boolean) automate_contenant_root.accepter(visitor)){
            System.out.println("Automates et ses sous automates valides.");
        }else{
            System.out.println("L'automate OU l'un de ses sous automates est invalide.");
        }
        root2.nom="B";

        System.out.println("\n-----Test 4--- non déterminisme");
        t2.etiquette.libelle="a";
        if((boolean) automate_contenant_root.accepter(visitor)){
            System.out.println("Automates et ses sous automates valides.");
        }else{
            System.out.println("L'automate OU l'un de ses sous automates est invalide.");
        }
        t2.etiquette.libelle="b";

        System.out.println("\n-----Test 5--- deux états initiaux");
        g1f2.isInitial = true;
        if((boolean) automate_contenant_root.accepter(visitor)){
            System.out.println("Automates et ses sous automates valides.");
        }else{
            System.out.println("L'automate OU l'un de ses sous automates est invalide.");
        }
        g1f2.isInitial = false;

        System.out.println("\n-----Test 6--- Aucun état initial (et donc erreur car l'ancien initial n'est cible d'aucune transition) ");
        g1f1.isInitial = false;
        if((boolean) automate_contenant_root.accepter(visitor)){
            System.out.println("Automates et ses sous automates valides.");
        }else{
            System.out.println("L'automate OU l'un de ses sous automates est invalide.");
        }
        g1f1.isInitial = true;

        System.out.println("\n-----Test 7--- Un état est cible d'aucune transition ");
        t3.etatCible=root;
        if((boolean) automate_contenant_root.accepter(visitor)){
            System.out.println("Automates et ses sous automates valides.");
        }else{
            System.out.println("L'automate OU l'un de ses sous automates est invalide.");
        }
        t3.etatCible=root2;

        System.out.println("\n-----Test 8--- Un état qui n'est la source d'aucune transition doit être final");
        root2.isLast=false;
        if((boolean) automate_contenant_root.accepter(visitor)){
            System.out.println("Automates et ses sous automates valides.");
        }else{
            System.out.println("L'automate OU l'un de ses sous automates est invalide.");
        }
        root2.isLast=true;


        System.out.println("\n-----Test 9--- Simulation de l'exécution d'un automate");
        transitBy(t1);
        transitBy(t4);
        transitBy(t2); // erreurs
        transitBy(t3);


    }

    private static void transitBy(Transition t){
        t.etatSource.source.transitBy(t);
    }
}
