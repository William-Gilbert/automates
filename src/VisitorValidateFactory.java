/**
 * Created by coren_000 on 18/02/2016.
 */
public class VisitorValidateFactory extends VisitorFactory {

    @Override
    protected VisitorValidateAutomate createVisitor() {
        VisitorValidateAutomate visitor = VisitorValidateSingle.getInstance();
        return visitor;
    }
}
