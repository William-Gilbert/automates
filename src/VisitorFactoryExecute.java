/**
 * Created by coren_000 on 18/02/2016.
 */
public class VisitorFactoryExecute extends VisitorFactory {
    @Override
    protected VisitorExectueAutomate createVisitor() {
        VisitorExectueAutomate visitor = VisitorExecuteSingle.getInstance();
        return visitor;
    }
}
