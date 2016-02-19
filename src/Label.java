/**
 * Le label des transitions d'un automate.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class Label{
    /**
     * L'étiquette de la transtion.
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
     * Renvoie la valeurs de l'étiquette.
     * @return
     *      Valeurs de l'étiquette.
     */
    public String toString(){
        return libelle;
    }


}
