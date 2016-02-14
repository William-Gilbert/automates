import java.util.Observable;
import java.util.Observer;

/**
 * Created by zoom3 on 02/02/2016.
 */
public class Transition extends Observable{
    public Etat etatSource;
    public Etat etatCible;
    public Label etiquette;

    public Transition(Etat etatSource, Etat etatCible, Label etiquette) {
        this.etatSource = etatSource;
        this.etatCible = etatCible;
        this.etiquette = etiquette;
    }

    public void notif(){
        /* Déclenche l'événement sur la transition, appelle la méthode update de TransitionObsevrer (cf TransitionObserver)*/
        setChanged();
        notifyObservers();
    }

    public String toString(){
        return "De \""+etatSource.nom+"\" à \""+etatCible.nom+"\" par \""+etiquette+"\"";
    }


    public void addObserver(TransitionObserver o){
        super.addObserver(o);
        o.add(this);
    }

}
