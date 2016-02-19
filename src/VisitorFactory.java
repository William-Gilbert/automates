/**
 * La fabrique de Visiteur
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public abstract class VisitorFactory {
    /**
     * Getter sur le visiteur de la fabrique.
     * @return
     *  Le visiteur créé avec la fabrique.
     */
    public Visitor getVisitor(){
        return createVisitor();
    }

    protected abstract Visitor createVisitor();
}
