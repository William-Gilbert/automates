/**
 * Singleton pour n'avoir qu'un seul visiteur de chaque type.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class VisitorExecuteSingle {
    private static final VisitorExecuteAutomate INST = new VisitorExecuteAutomate();

    /**
     * Constructeur priv� pour ne pas pouvoir instancier le singleton.
     */
    private VisitorExecuteSingle(){}

    /**
     * @return
     *      Le visiteur �xecutant un automate.
     */
    public static VisitorExecuteAutomate getInstance(){
        return INST;
    }
}
