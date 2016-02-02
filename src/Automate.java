import java.util.ArrayList;

/**
 * Created by zoom3 on 02/02/2016.
 */
public class Automate {
    public ArrayList<Etat> listEtat;
    public ArrayList<Transition> listTransition;
    public Etat etatCourant;

    public Automate() {
        listEtat = new ArrayList<Etat>();
        listTransition = new ArrayList<Transition>();
        etatCourant = null;
    }

    public boolean ajouterEtat(Etat e) {
        return e != null && listEtat.add(e);

    }

    public boolean ajouterTransition(Transition t){
        return t != null && listTransition.add(t);
    }

    public String toString(){
        return etatCourant.toString();
    }

}
