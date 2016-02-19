/**
 * Le label des transitions d'un automate.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class Label{
    /**
     * L'�tiquette de la transtion.
     */
    public String libelle;

    /**
     * Constructeur du label d'une transition.
     * @param s
     */
    public Label(String s){
        libelle = s;
    }

    /**
     * Renvoie la valeurs de l'�tiquette.
     * @return
     *      Valeurs de l'�tiquette.
     */
    public String toString(){
        return libelle;
    }


}
