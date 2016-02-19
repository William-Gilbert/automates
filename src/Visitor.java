/**
 * Super classe des Visiteur, utile dans l'utilisation des fabriques.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class Visitor implements Visiteur {
    /**
     * @see Visiteur#visit(Automate, String)
     */
    @Override
    public Object visit(Automate a, String cas) {
        return null;
    }

    /**
     * @see Visiteur#visit(Etat, String)
     */
    @Override
    public Object visit(Etat e, String cas) {
        return null;
    }

    /**
     * @see Visiteur#visit(Transition, String)
     */
    @Override
    public Object visit(Transition t, String cas) {
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
