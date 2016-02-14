/**
 * Created by william on 14/02/2016.
 */
public class VisitorExectueAutomate implements Visiteur {


    @Override
    public Object visit(Automate a, String cas) {
        if(cas.equals("execute")){

        }
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
