/**
 * Interface des visiteurs.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */

public interface Visiteur {
    /**
     * Visite un automate.
     * @param a
     *      Automate � visiter.
     * @param cas
     *      Cas de visite.
     * @return
     *      Un objet en fonction du cas de la visite.
     */
    Object visit(Automate a, String cas);

    /**
     * Visite un �tat.
     * @param e
     *      Etat � visiter.
     * @param cas
     *      Cas de visite.
     * @return
     *      Un objet en fonction du cas de la visite.
     */
    Object visit(Etat e, String cas);

    /**
     * Visite une transition.
     * @param t
     *      Transition � visiter.
     * @param cas
     *      Cas de visite.
     * @return
     *      Un objet en fonction du cas de la visite.
     */
    Object visit(Transition t, String cas);

    /**
     * Visite un Label.
     * @param l
     *      Label � visiter.
     * @param cas
     *      Cas de visite.
     * @return
     *      Un objet en fonction du cas de la visite.
     */
    Object visit(Label l, String cas);

}
