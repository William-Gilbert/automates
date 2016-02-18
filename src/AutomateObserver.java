import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by william on 14/02/2016.
 */
public class AutomateObserver implements Observer {

    private ArrayList<Automate> automatesConcernedByObserver = null;

    public AutomateObserver(){
        automatesConcernedByObserver = new ArrayList<Automate>();
    }

    @Override
    public void update(Observable o, Object arg) {

        Transition t = (Transition)arg;
        /* Si l'événement qui a appelé la méthode est du type de la transition associé, on déclenche l'exécution */
        for(Automate a : automatesConcernedByObserver){
            if(a == t.etatSource.source){
                t.accepter(new VisitorExectueAutomate());
            }
        }



    }

    public void add(Automate a){
        automatesConcernedByObserver.add(a);
    }
}
