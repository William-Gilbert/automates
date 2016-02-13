/**
 * Created by zoom3 on 02/02/2016.
 */
public class Application {

    public static void main(String[] args){
        Automate automate_contenant_root = new Automate("root");
        Automate premier_sous_automate_de_root = new Automate("Génération1");
        Automate premier_sous_automate_du_premier_filsEtat_de_root = new Automate("Génération 2 1");
        Automate premier_sosu_automate_du_deuxieme_filsEtat_de_root = new Automate("Génération 2 2");

        Etat root = new Etat(automate_contenant_root,"root",true,false);
        Etat root2 = new Etat(automate_contenant_root, "root2", false, true);
        Etat g1f1 = new Etat(premier_sous_automate_de_root,"g1f1",true,false);
        Etat g1f2 = new Etat(premier_sous_automate_de_root,"g1f1",false,true);
        Etat g1f3 = new Etat(premier_sous_automate_de_root,"g1f3",false,true);

        Etat g2f1 = new Etat(premier_sous_automate_du_premier_filsEtat_de_root,"g2f1",true,true);

        Etat g2f2 = new Etat(premier_sosu_automate_du_deuxieme_filsEtat_de_root,"g2f2",true,true);


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

        automate_contenant_root.etatCourant = automate_contenant_root.listEtat.get(0);
        premier_sous_automate_de_root.etatCourant = premier_sous_automate_de_root.listEtat.get(0);
        premier_sous_automate_du_premier_filsEtat_de_root.etatCourant = premier_sous_automate_du_premier_filsEtat_de_root.listEtat.get(0);
        premier_sosu_automate_du_deuxieme_filsEtat_de_root.etatCourant = premier_sosu_automate_du_deuxieme_filsEtat_de_root.listEtat.get(0);


        premier_sous_automate_de_root.ajouterTransition(new Transition(g1f1,g1f2, new Label("a")));
        premier_sous_automate_de_root.ajouterTransition(new Transition(g1f1,g1f3, new Label("b")));
        automate_contenant_root.ajouterTransition(new Transition(root,root2, new Label("b")));

        String r = automate_contenant_root.toString();
        System.out.print(r);

        if((boolean) automate_contenant_root.accepter(new VisitorValidateAutomate())){
            System.out.println("Automates et ses sous automates valides.");
        }else{
            System.out.println("Automates OU un de ses sous automates invalides.");
        }
    }
}
