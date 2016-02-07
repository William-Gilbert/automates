import java.util.ArrayList;

/**
 * Created by zoom3 on 02/02/2016.
 * Repr�sente un �tat hierarchique d'un automate (qui peut contenir d'autre automate)
 */
public class Etat implements Visiteur {
    public String nom;
    public boolean initial;
    public boolean last;
    public ArrayList<Automate> sousAutomates;

    public Etat(String nom, boolean initial, boolean last) {
        this.nom = nom;
        this.initial = initial;
        this.last = last;
        sousAutomates = new ArrayList<Automate>();
    }

    public boolean ajouterSousAutomate(Automate a){
        return a != null &&  sousAutomates.add(a);
    }

    public String toString(){
        String ts = nom;
        for(Automate a :  sousAutomates){
            ts+="." +a.etatCourant.toString()+"\n";
        }
        return ts;
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
