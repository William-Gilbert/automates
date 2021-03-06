import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Visiteur validant un automate ou non.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class AutomateObserver implements Observer {

    private ArrayList<Automate> automatesConcernedByObserver = null;

    public AutomateObserver(){
        automatesConcernedByObserver = new ArrayList<Automate>();
    }

    @Override
    public void update(Observable o, Object arg) {

        Transition t = (Transition)arg;
        /* Si l'�v�nement qui a appel� la m�thode est du type de la transition associ�, on d�clenche l'ex�cution */
        for(Automate a : automatesConcernedByObserver){
            if(a == t.etatSource.source){
                VisitorFactoryExecute vfe = new VisitorFactoryExecute();
                VisitorExecuteAutomate visitor = vfe.createVisitor();
                t.accepter(visitor);
            }
        }



    }

    public void add(Automate a){
        automatesConcernedByObserver.add(a);
    }
}
