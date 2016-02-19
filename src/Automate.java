import java.util.ArrayList;
import java.util.Observable;

/**
 * Permet de créer un automate, cet automate réagit aux événements et intègre un visiteur
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class Automate extends Observable implements VisitAccept {
    /**
     * La liste des états de l'automate
     */
    public ArrayList<Etat> listEtat;
    /**
     * La liste des transitions de l'automate
     */
    public ArrayList<Transition> listTransition;
    /**
     * L'état courant dans l'exécution de l'automate
     */
    public Etat etatCourant;
    /**
     * Le nom de l'automate pour l'affichage
     */
    public String nom;


    /**
     * Crée un automate avec un état courant null
     * @param nom
     *      Le nom de l'automate
     */
    public Automate(String nom) {
        listEtat = new ArrayList<Etat>();
        listTransition = new ArrayList<Transition>();
        etatCourant = null;
        this.nom = nom;
    }


    /**
     * Permet d'ajouter un écouter d'événement sur la classe automate
     * @param o
     *      L'observer d'automate.
     */
    public void addObserver(AutomateObserver o ){
        super.addObserver(o);
        o.add(this);
    }

    /**
     * Permet d'ajouter un état à l'automate. Si cet état est initial, l'état courant
     * de l'automate devient cet état.
     * @param e
     *      L'état à ajouter à l'automate
     * @return
     *      Un booléén indiquant si l'ajout à bien eu lieu.
     */
    public boolean ajouterEtat(Etat e) {
        if(e.isInitial){
            etatCourant = e;
        }
        return e != null && listEtat.add(e);

    }

    /**
     * Permet de lancer l'événement de transition dans l'automate.
     * @param t
     *      La transition qui doit avoir lieu.
     */
    public void transitBy(Transition t){
        setChanged();
        notifyObservers(t);
    }

    /**
     * Ajouter une transition à l'automate.
     * @param t
     *      La transition à ajouter
     * @return
     *      Un booléen indiquant si oui ou non l'ajout à eu lieu.
     */
    public boolean ajouterTransition(Transition t){
        return t != null && listTransition.add(t);
    }

    /**
     * Renvoie le nom de l'automate
     * @return
     *      Le nom de l'automate
     */
    @Override
    public String toString(){
        return etatCourant.toString();
    }


    /**
     * Accepter un visiteur et commencer le travail de celui-ci.
     * @param v
     *      Le visiteur concerné.
     * @return
     *      Le résultats de la visite.
     */
    @Override
    public Object accepter(Visiteur v){return v.visit(this, "entryPoint");}
}
