/**
 * Singleton pour n'avoir qu'un seul visiteur de chaque type.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class VisitorExecuteSingle {
    private static final VisitorExecuteAutomate INST = new VisitorExecuteAutomate();

    /**
     * Constructeur privé pour ne pas pouvoir instancier le singleton.
     */
    private VisitorExecuteSingle(){}

    /**
     * @return
     *      Le visiteur éxecutant un automate.
     */
    public static VisitorExecuteAutomate getInstance(){
        return INST;
    }
}
