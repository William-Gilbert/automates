/**
 * Visiteur d'automate permettant l'exécution de celui-ci.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class VisitorExecuteAutomate extends Visitor {

    /**
     * @see Visiteur#visit(Automate, String)
     */
    @Override
    public Object visit(Automate a, String cas) {
        switch (cas) {
            case "initial":
                // Renvoie l'état initial de l'automate
                for (Etat e : a.listEtat) {
                    if ((boolean) visit(e, "initial")) {
                        return e;
                    }
                }
                break;
            case "automate":
                // Renvoie l'automate
                return a;
            case "etatCourant":
                // Renvoie l'état courant de l'automate
                return a.etatCourant;
        }
        return null;
    }

    /**
     * @see Visiteur#visit(Etat, String)
     */
    @Override
    public Object visit(Etat e, String cas) {
        switch (cas) {
            case "initial":
                // Renvoie un booléen indiquant si l'état est initial ou pas
                return e.isInitial;
            case "automate":
                // Renvoie l'automate source de l'état
                return visit(e.source, "automate");
            case "nomAutomate":
                // Renvoie le nom de l'automate de l'état
                return ((Automate) visit(e.source, "automate")).nom;
            case "nom":
                // Renvoie le nom de l'état
                return e.nom;
            case "isEtatCourant":
                // Renvoie un booléen vérifiant si l'état est l'état courant de l'automate
                return e == visit(e.source, "etatCourant");
            case "definirCommeCourant":
                // Définit l'état e comme état courant de l'automate
                ((Automate) visit(e.source, "automate")).etatCourant = e;
                return true;
        }
        return null;
    }

    /**
     * @see Visiteur#visit(Transition, String)
     */
    @Override
    public Object visit(Transition t, String cas) {
        if(cas.equals("entryPoint")){
            // Point d'entrée du visiteur d'execution de l'automate
            if((boolean)visit(t.etatSource, "isEtatCourant")){
                // Affiche la transition qui a lieu
                System.out.println("Transition dans automate \""
                        +visit(t.etatSource, "nomAutomate")+"\"\n"+
                "| de "+visit(t.etatSource, "nom")+" à "+visit(t.etatCible,"nom") );
                // Définit la transition dans le modèle de donnée
                visit(t.etatCible, "definirCommeCourant");
            }else
                System.out.println("La transition ne s'applique pas à l'état courant");
        }
        return null;
    }

    /**
     * @see Visiteur#visit(Label, String)
     */
    @Override
    public Object visit(Label l, String cas) {
        return null;
    }
}
