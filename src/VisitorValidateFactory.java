/**
 * Crée un visiteur pour la validation de l'automate.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class VisitorValidateFactory extends VisitorFactory {

    @Override
    protected VisitorValidateAutomate createVisitor() {
        VisitorValidateAutomate visitor = VisitorValidateSingle.getInstance();
        return visitor;
    }
}
