import java.util.ArrayList;
import java.util.Observable;

/**
 * Permet de cr�er un automate, cet automate r�agit aux �v�nements et int�gre un visiteur
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class Automate extends Observable implements VisitAccept {
    /**
     * La liste des �tats de l'automate
     */
    public ArrayList<Etat> listEtat;
    /**
     * La liste des transitions de l'automate
     */
    public ArrayList<Transition> listTransition;
    /**
     * L'�tat courant dans l'ex�cution de l'automate
     */
    public Etat etatCourant;
    /**
     * Le nom de l'automate pour l'affichage
     */
    public String nom;


    /**
     * Cr�e un automate avec un �tat courant null
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
     * Permet d'ajouter un �couter d'�v�nement sur la classe automate
     * @param o
     *      L'observer d'automate.
     */
    public void addObserver(AutomateObserver o ){
        super.addObserver(o);
        o.add(this);
    }

    /**
     * Permet d'ajouter un �tat � l'automate. Si cet �tat est initial, l'�tat courant
     * de l'automate devient cet �tat.
     * @param e
     *      L'�tat � ajouter � l'automate
     * @return
     *      Un bool��n indiquant si l'ajout � bien eu lieu.
     */
    public boolean ajouterEtat(Etat e) {
        if(e.isInitial){
            etatCourant = e;
        }
        return e != null && listEtat.add(e);

    }

    /**
     * Permet de lancer l'�v�nement de transition dans l'automate.
     * @param t
     *      La transition qui doit avoir lieu.
     */
    public void transitBy(Transition t){
        setChanged();
        notifyObservers(t);
    }

    /**
     * Ajouter une transition � l'automate.
     * @param t
     *      La transition � ajouter
     * @return
     *      Un bool�en indiquant si oui ou non l'ajout � eu lieu.
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
     *      Le visiteur concern�.
     * @return
     *      Le r�sultats de la visite.
     */
    @Override
    public Object accepter(Visiteur v){return v.visit(this, "entryPoint");}
}
