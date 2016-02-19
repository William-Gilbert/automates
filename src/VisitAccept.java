/**
 * Interface pour les classes qui accepte un visiteur.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public interface VisitAccept {
    /**
     * Permet de lancer le traitement d'un visiteur.
     * @param v
     *      Visiteur.
     * @return
     *      Résultat de la visite du visiteur.
     */
    abstract public Object accepter(Visiteur v);
}
