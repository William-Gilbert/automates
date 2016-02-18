/**
 * Created by coren_000 on 18/02/2016.
 */
public abstract class VisitorFactory {
    public VisitorValidateAutomate getVisitor(){
        return createVisitor();
    }

    protected abstract VisitorValidateAutomate createVisitor();
}
