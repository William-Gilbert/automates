/**
 * Created by coren_000 on 18/02/2016.
 */
public class VisitorExecuteSingle {
    private static final VisitorExectueAutomate INST = new VisitorExectueAutomate();

    private VisitorExecuteSingle(){}

    public static VisitorExectueAutomate getInstance(){
        return INST;
    }
}
