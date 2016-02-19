/**
 * Cr�er un visiteur d'ex�cution de l'automate.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class VisitorFactoryExecute extends VisitorFactory {
    /**
     * Cr�e un visiteur pour l'ex�cution de l'automate.
     * @return
     *      Le visiteur.
     */
    @Override
    protected VisitorExecuteAutomate createVisitor() {
        VisitorExecuteAutomate visitor = VisitorExecuteSingle.getInstance();
        return visitor;
    }
}
