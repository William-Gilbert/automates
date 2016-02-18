/**
 * Created by coren_000 on 18/02/2016.
 */
public class Visitor implements Visiteur {
    @Override
    public Object visit(Automate a, String cas) {
        return null;
    }

    @Override
    public Object visit(Etat e, String cas) {
        return null;
    }

    @Override
    public Object visit(Transition t, String cas) {
        return null;
    }

    @Override
    public Object visit(Label l, String cas) {
        return null;
    }
}
