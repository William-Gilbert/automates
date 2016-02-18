/**
 * Created by william on 14/02/2016.
 */
public class VisitorExectueAutomate extends Visitor {


    @Override
    public Object visit(Automate a, String cas) {
        if(cas.equals("initial")){
            for(Etat e : a.listEtat){
                if((boolean)visit(e,"initial")){
                    return e;
                }
            }
        }
        return null;
    }

    @Override
    public Object visit(Etat e, String cas) {
        if(cas.equals("initial")){
            return e.isInitial;
        }
        return null;
    }

    @Override
    public Object visit(Transition t, String cas) {
        Etat init = (Etat)visit(t.etatSource.source,"initial");

        return null;
    }

    @Override
    public Object visit(Label l, String cas) {
        return null;
    }
}
