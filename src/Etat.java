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
        sousAutomates = new ArrayList<Automate>();
    }

    public boolean ajouterSousAutomate(Automate a){
        return a != null &&  sousAutomates.add(a);
    }

    public String toString(){
        String ts = nom;
        for(Automate a :  sousAutomates){
            nom+="." +a.etatCourant.toString()+"\n";
        }
        return ts;
    }
}
