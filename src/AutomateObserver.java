import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * R�agit � l'�v�nement de transition de la classe Automate
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class AutomateObserver implements Observer {

    /**
     *  Une liste d'automate observ�.
     */
    private ArrayList<Automate> automatesConcernedByObserver = null;

    /**
     *  Instancie la liste des automates observ�s.
     */
    public AutomateObserver(){
        automatesConcernedByObserver = new ArrayList<Automate>();
    }

    /**
     * M�thode appel� lors de la notification de l'�v�nement.
     *
     * @param o
     *      L'obersveur de la classe Automate
     * @param arg
     *      Argument donn� en param�tre de la m�thode notifyObserver() de la classe automate
     */
    @Override
    public void update(Observable o, Object arg) {
        Transition t = (Transition)arg;
        /* Si l'�v�nement qui a appel� la m�thode est du type de la transition associ�, on d�clenche l'ex�cution */
        for(Automate a : automatesConcernedByObserver){
            if(a == t.etatSource.source){
                t.accepter(new VisitorExecuteAutomate());
            }
        }
    }

    /**
     * Ajouter un automate � la liste des automates observ�s.
     * @param a
     *      L'automate � ajout�.
     */
    public void add(Automate a){
        automatesConcernedByObserver.add(a);
    }
}
