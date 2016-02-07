import java.util.ArrayList;

/**
 * Created by zoom3 on 02/02/2016.
 */
public class Automate implements Visiteur {
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

    @Override
    public Object visit(Automate A) {
        return null;
    }

    @Override
    public Object visit(Etat e) {
        return null;
    }

    @Override
    public Object visit(Transition t) {
        return null;
    }

    @Override
    public Object visit(Label l) {
        return null;
    }
}
