import java.util.HashSet;
import java.util.Set;

/**
 * Cette classe définit le corps des méthodes de visit
 */

public class Interpreter implements Visiteur{

    @Override
    public Object visit(Automate a) {
        for (Etat e : a.listEtat){
            for(Etat e2 : a.listEtat){
                if(e!=e2 && ((String)visit(e,"display")).equals(((String)visit(e2,"display")))){//Cast peut-être inutile
                    return false;
                }
            }
            // Traiteemnt type d'objet
            for(Automate sous_automates : e.sousAutomates){
                if(!(boolean)visit(sous_automates))return false;
            }
            visit(e,"transition");
        }
        return true;
    }

    @Override
    public Object visit(Etat e, String cas) {
        if(cas.equals("transition")){
            // visit
        }
        return e.getNom();
    }

    @Override
    public Object visit(Transition t) {
        return visit(t.etiquette);
    }

    @Override
    public Object visit(Label l) {
        return l.etiquette;
    }


}
