/**
 * Créer un visiteur d'exécution de l'automate.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class VisitorFactoryExecute extends VisitorFactory {
    /**
     * Crée un visiteur pour l'exécution de l'automate.
     * @return
     *      Le visiteur.
     */
    @Override
    protected VisitorExecuteAutomate createVisitor() {
        VisitorExecuteAutomate visitor = VisitorExecuteSingle.getInstance();
        return visitor;
    }
}
