import java.util.ArrayList;

/**
 * La classe état des automates.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class Etat implements VisitAccept{
    /**
     * Le nom de l'état.
     */
    public String nom;
    /**
     * Indique si l'état est un état initial.
     */
    public boolean isInitial;
    /**
     * Indique si l'état est un état final.
     */
    public boolean isLast;
    /**
     * L'automate source à qui appartient cet automate.
     */
    public Automate source;
    /**
     * Une liste de sous-automate contenu dans l'état.
     */
    public ArrayList<Automate> sousAutomates;

    /**
     * Construit un état.
     *
     * @param source
     *      L'automate a qui appartient l'état.
     * @param nom
     *      Le nom du nouvel état.
     * @param initial
     *      Indique si l'état est initial.
     * @param last
     *      Indique si l'état est final.
     */
    public Etat(Automate source,String nom, boolean initial, boolean last) {
        this.nom = nom;
        this.isInitial = initial;
        this.isLast = last;
        sousAutomates = new ArrayList<Automate>();
        this.source = source;
    }

    /**
     * Permet d'ajouter un sous-automate à l'état.
     *
     * @param a
     *      Le sous-automate à ajouter.
     * @return
     *      Un booléen indiquant si l'ajout à bien eu lieu.
     */
    public boolean ajouterSousAutomate(Automate a){
        return a != null &&  sousAutomates.add(a);
    }

    /**
     * Renvoie la liste des états courants de chaque sous automate.
     * @return
     *      La chaîne contenant les sous états courant de l'état.
     */
    public String toString(){
        String ts = nom;
        for(Automate a :  sousAutomates){
            ts+="." +a.etatCourant.toString();
        }
        return ts;
    }

    /**
     * Renvoie une chaine du nom de l'état.
     * @return
     *      Chaine du nom de l'état.
     */
    public String getNom(){
        return nom;
    }


    /**
     * Accepte un visiteur v et commence son traitement dans le cas "display"
     * @param v
     *      Visiteur de l'automate.
     * @return
     *      Résultat de la visite.
     */
    @Override
    public Object accepter(Visiteur v){return v.visit(this, "display");}
}
