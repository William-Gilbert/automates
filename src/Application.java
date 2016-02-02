import java.util.ArrayList;

/**
 * Created by zoom3 on 02/02/2016.
 */
public class Application {

    public static void main(String[] args){
        Automate automate_contenant_root = new Automate();
        Automate premier_sous_automate_de_root = new Automate();
        Automate premier_sous_automate_du_premier_filsEtat_de_root = new Automate();
        Automate premier_sosu_automate_du_deuxieme_filsEtat_de_root = new Automate();

        Etat root = new Etat("Root",true,false);
        Etat g1f1 = new Etat("g1f1",false,false);
        Etat g1f2 = new Etat("g1f2",false,false);
        Etat g1f3 = new Etat("g1f3",false,true);

        Etat g2f1 = new Etat("g2f1",false,true);
        Etat g2f2 = new Etat("g2f2",false,true);


        automate_contenant_root.ajouterEtat(root);
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
        System.out.println(automate_contenant_root.toString());

    }
}
