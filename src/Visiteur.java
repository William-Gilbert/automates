import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/**
 * Created by coren_000 on 07/02/2016.
 */
public interface Visiteur {
    Object visit(Automate a, String cas);
    Object visit(Etat e, String cas);
    Object visit(Transition t, String cas);
    Object visit(Label l, String cas);

}
