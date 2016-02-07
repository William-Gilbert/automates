/**
 * Created by zoom3 on 02/02/2016.
 */
public class Label implements Visiteur{
    public String etiquette;

    @Override
    public Object visit(Automate A) {
        return null;
    }

    @Override
    public Object visit(Etat e) {
        return null;
    }

    @Override
    public Object visit(Transition t) {
        return null;
    }

    @Override
    public Object visit(Label l) {
        return null;
    }
}
