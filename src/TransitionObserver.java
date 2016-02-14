import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by william on 14/02/2016.
 */
public class TransitionObserver implements Observer {

    private ArrayList<Transition> transitionsConcernedByObserver = null;

    public TransitionObserver(){
        transitionsConcernedByObserver = new ArrayList<Transition>();
    }

    @Override
    public void update(Observable o, Object arg) {
        /* Si l'événement qui a appelé la méthode est du type de la transition associé, on déclenche l'exécution */
        for(Transition t : transitionsConcernedByObserver){
            if( o == t){
                System.out.println("Add transition : "+t.toString());
            }
        }

    }

    public void add(Transition t){
        transitionsConcernedByObserver.add(t);
    }
}
