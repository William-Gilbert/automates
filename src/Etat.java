import java.util.ArrayList;

/**
 * Created by zoom3 on 02/02/2016.
 * Représente un état hierarchique d'un automate (qui peut contenir d'autre automate)
 */
public class Etat {
    public String nom;
    public boolean initial;
    public boolean last;
    public ArrayList<Automate> sousAutomates;

    public Etat(String nom, boolean initial, boolean last) {
        this.nom = nom;
        this.initial = initial;
        this.last = last;
    }

    public boolean ajouterSousAutomate(Automate a){
        if(a == null){
            return false;
        }

        // TODO Fonction

        return true;
    }
}
