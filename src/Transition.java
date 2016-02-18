import java.util.Observable;
import java.util.Observer;

/**
 * Created by zoom3 on 02/02/2016.
 */
public class Transition implements VisitAccept{
    public Etat etatSource;
    public Etat etatCible;
    public Label etiquette;

    public Transition(Etat etatSource, Etat etatCible, Label etiquette) {
        this.etatSource = etatSource;
        this.etatCible = etatCible;
        this.etiquette = etiquette;
    }



    public String toString(){
        return "De \""+etatSource.nom+"\" à \""+etatCible.nom+"\" par \""+etiquette+"\"";
    }

    @Override
    public Object accepter(Visiteur v){return v.visit(this, "entryPoint");}


}
