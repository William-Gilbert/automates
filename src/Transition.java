/**
 * Transition d'un état à l'autre dans un automate.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class Transition implements VisitAccept{
    /**
     * L'état source de la transition.
     */
    public Etat etatSource;
    /**
     * L'état cible de la transition.
     */
    public Etat etatCible;
    /**
     * Valeurs de la transition.
     */
    public Label etiquette;

    /**
     * Constructeur de la transition.
     *
     * @param etatSource
     *      Etat source de la transition.
     * @param etatCible
     *      Etat cible de la transition.
     * @param etiquette
     *      Valeurs de la transition.
     */
    public Transition(Etat etatSource, Etat etatCible, Label etiquette) {
        this.etatSource = etatSource;
        this.etatCible = etatCible;
        this.etiquette = etiquette;
    }


    /**
     * @return
     *      Chaine de caractère modélisant la transition.
     */
    public String toString(){
        return "De \""+etatSource.nom+"\" à \""+etatCible.nom+"\" par \""+etiquette+"\"";
    }

    /**
     * Accepter un visiteur.
     * @param v
     *      Visiteur de transition.
     * @return
     *      Résultat de la visite.
     */
    @Override
    public Object accepter(Visiteur v){return v.visit(this, "entryPoint");}


}
