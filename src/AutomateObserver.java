import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Réagit à l'événement de transition de la classe Automate
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class AutomateObserver implements Observer {

    /**
     *  Une liste d'automate observé.
     */
    private ArrayList<Automate> automatesConcernedByObserver = null;

    /**
     *  Instancie la liste des automates observés.
     */
    public AutomateObserver(){
        automatesConcernedByObserver = new ArrayList<Automate>();
    }

    /**
     * Méthode appelé lors de la notification de l'événement.
     *
     * @param o
     *      L'obersveur de la classe Automate
     * @param arg
     *      Argument donné en paramètre de la méthode notifyObserver() de la classe automate
     */
    @Override
    public void update(Observable o, Object arg) {
        Transition t = (Transition)arg;
        /* Si l'événement qui a appelé la méthode est du type de la transition associé, on déclenche l'exécution */
        for(Automate a : automatesConcernedByObserver){
            if(a == t.etatSource.source){
                t.accepter(new VisitorExecuteAutomate());
            }
        }
    }

    /**
     * Ajouter un automate à la liste des automates observés.
     * @param a
     *      L'automate à ajouté.
     */
    public void add(Automate a){
        automatesConcernedByObserver.add(a);
    }
}
