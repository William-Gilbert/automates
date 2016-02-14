import java.util.ArrayList;

/**
 * Created by zoom3 on 02/02/2016.
 */
public class Automate implements VisitAccept {
    public ArrayList<Etat> listEtat;
    public ArrayList<Transition> listTransition;
    public Etat etatCourant;
    public String nom;


    public Automate(String nom) {
        listEtat = new ArrayList<Etat>();
        listTransition = new ArrayList<Transition>();
        etatCourant = null;
        this.nom = nom;
    }

    public boolean ajouterEtat(Etat e) {
        return e != null && listEtat.add(e);

    }

    public boolean ajouterTransition(Transition t){
        /* Lorsqu'on ajoute une transition à l'automate, on déclenche un événement qui va entrainer l'éxécution de l'automate
        avec le visiteur VisitorExecuteAutomate
         */
        t.notif();
        return t != null && listTransition.add(t);
    }

    public String toString(){
        return etatCourant.toString();
    }



    @Override
    public Object accepter(Visiteur v){return v.visit(this, "validAut");}
}
