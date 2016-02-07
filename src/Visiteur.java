/**
 * Created by coren_000 on 07/02/2016.
 */
public interface Visiteur {
    Object visit(Automate A);
    Object visit(Etat e);
    Object visit(Transition t);
    Object visit(Label l);
}
