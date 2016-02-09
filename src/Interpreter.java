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
                //affiche le déroulement des actions
                //lorsqu'il voit true true il devrait retourner false mais il ne le fait pas
                //et il ne parcours pas tout à chaque fois, il fait une vérification au lieu de de 3 par etat !
                String s1=(String)visit(e);
                String s2=(String)visit(e2);
                System.out.println(s1+" "+s2);
                System.out.print(e!=e2);
                System.out.println(s1.equals(s2));
                if(e!=e2 && s1.equals(s2)){
                    return false;
                }
            }
            // Traiteemnt type d'objet
            for(Automate sa : e.sousAutomates){if(visit(sa)==null)return false;}
            visit(e);
        }
        return true;
    }

    @Override
    public Object visit(Etat e) {
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
