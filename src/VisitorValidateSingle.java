/**
 * Created by coren_000 on 18/02/2016.
 */
public class VisitorValidateSingle {
    private static final VisitorValidateAutomate INST = new VisitorValidateAutomate();

    private VisitorValidateSingle(){}

    public static VisitorValidateAutomate getInstance(){
        return INST;
    }
}
