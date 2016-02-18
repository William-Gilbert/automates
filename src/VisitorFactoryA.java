/**
 * Created by coren_000 on 18/02/2016.
 */
public class VisitorFactoryA extends VisitorFactory {

    @Override
    protected VisitorValidateAutomate createVisitor() {
        VisitorValidateAutomate visitor = VisitorSingle.getInstance();
        return visitor;
    }
}
