/**
 * Created by coren_000 on 18/02/2016.
 */
public abstract class VisitorFactory {
    public Visitor getVisitor(){
        return createVisitor();
    }

    protected abstract Visitor createVisitor();
}
