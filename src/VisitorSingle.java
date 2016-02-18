/**
 * Created by coren_000 on 18/02/2016.
 */
public class VisitorSingle {
    private static final VisitorValidateAutomate INST = new VisitorValidateAutomate();

    private VisitorSingle(){}

    public static VisitorValidateAutomate getInstance(){
        return INST;
    }
}
