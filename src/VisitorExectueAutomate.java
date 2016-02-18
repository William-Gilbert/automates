/**
 * Created by william on 14/02/2016.
 */
public class VisitorExectueAutomate extends Visitor {


    @Override
    public Object visit(Automate a, String cas) {
        if(cas.equals("entryPoint")){
            System.out.println("TEST");
        }
        else if(cas.equals("initial")){
            for(Etat e : a.listEtat){
                if((boolean)visit(e,"initial")){
                    return e;
                }
            }
        }else if(cas.equals("automate")){
            return a;
        }
        else if(cas.equals("etatCourant")){

            return a.etatCourant;
        }
        return null;
    }

    @Override
    public Object visit(Etat e, String cas) {
        if(cas.equals("initial")){
            return e.isInitial;
        }
        else if(cas.equals("automate")){
            return visit(e.source,"automate");
        }
        else if(cas.equals("nomAutomate")){
            return ((Automate)visit(e.source, "automate")).nom;
        }
        else if(cas.equals("nom")){
            return e.nom;
        }
        else if(cas.equals("isEtatCourant")){
            return e == visit(e.source, "etatCourant");
        }
        else if(cas.equals("definirCommeCourant")){
            ((Automate)visit(e.source, "automate")).etatCourant = e;
            return true;
        }
        return null;
    }

    @Override
    public Object visit(Transition t, String cas) {
        if(cas.equals("entryPoint")){
            if((boolean)visit(t.etatSource, "isEtatCourant")){
                System.out.println("Transition dans automate \""
                        +visit(t.etatSource, "nomAutomate")+"\"\n"+
                "| de "+visit(t.etatSource, "nom")+" à "+visit(t.etatCible,"nom") );
                visit(t.etatCible, "definirCommeCourant");
            }else System.out.println("La transition ne s'applique pas à l'état courant");
            //visit(t.etatSource, "automate");
        }

        return null;
    }

    @Override
    public Object visit(Label l, String cas) {
        return null;
    }
}
