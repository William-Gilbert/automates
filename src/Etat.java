import java.util.ArrayList;

/**
 * Created by zoom3 on 02/02/2016.
 * Repr�sente un �tat hierarchique d'un automate (qui peut contenir d'autre automate)
 */
public class Etat implements VisitAccept{
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
    public String getNom(){
        return nom;
    }


    @Override
    public Object accepter(Visiteur v){return v.visit(this);}
}
