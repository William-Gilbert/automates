import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by zoom3 on 02/02/2016.
 */
public class Automate extends Observable implements VisitAccept {
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


    public void addObserver(AutomateObserver o ){
        super.addObserver(o);
        o.add(this);
    }
    public boolean ajouterEtat(Etat e) {
        if(e.isInitial){
            etatCourant = e;
        }
        return e != null && listEtat.add(e);

    }

    public void transitBy(Transition t){
        setChanged();
        notifyObservers(t);
    }

    public boolean ajouterTransition(Transition t){
        /* Lorsqu'on ajoute une transition à l'automate, on déclenche un événement qui va entrainer l'éxécution de l'automate
        avec le visiteur VisitorExecuteAutomate
         */
        return t != null && listTransition.add(t);
    }

    public String toString(){
        return etatCourant.toString();
    }



    @Override
    public Object accepter(Visiteur v){return v.visit(this, "entryPoint");}
}
