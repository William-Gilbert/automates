import java.util.ArrayList;

/**
 * Created by zoom3 on 02/02/2016.
 * Repr�sente un �tat hierarchique d'un automate (qui peut contenir d'autre automate)
 */
public class Etat implements VisitAccept{
    public String nom;
    public boolean isInitial;
    public boolean isLast;
    public Automate source;
    public ArrayList<Automate> sousAutomates;

    public Etat(Automate source,String nom, boolean initial, boolean last) {
        this.nom = nom;
        this.isInitial = initial;
        this.isLast = last;
        sousAutomates = new ArrayList<Automate>();
        this.source = source;
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
    public Object accepter(Visiteur v){return v.visit(this, "display");}
}
