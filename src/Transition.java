/**
 * Created by zoom3 on 02/02/2016.
 */
public class Transition implements Visiteur{
    public Etat etatSource;
    public Etat etatCible;
    public Label etiquette;

    public Transition(Etat etatSource, Etat etatCible, Label etiquette) {
        this.etatSource = etatSource;
        this.etatCible = etatCible;
        this.etiquette = etiquette;
    }


    @Override
    public Object visit() {
        return null;
    }
}
