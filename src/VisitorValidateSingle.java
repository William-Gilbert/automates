/**
 * Singleton pour le visiteur validant l'automate.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class VisitorValidateSingle {
    private static final VisitorValidateAutomate INST = new VisitorValidateAutomate();

    private VisitorValidateSingle(){}

    public static VisitorValidateAutomate getInstance(){
        return INST;
    }
}
