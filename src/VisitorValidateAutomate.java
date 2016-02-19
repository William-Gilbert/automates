import java.util.ArrayList;
import java.util.HashSet;

/**
 * Visiteur validant un automate ou non.
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */

public class VisitorValidateAutomate extends Visitor{

    /**
     * @see Visiteur#visit(Automate, String)
     */
    @Override
    public Object visit(Automate a, String cas) {
        if(cas.equals("unicité")){
            // vérifie l'unicité de l'automate courant
            boolean retour = true;
            retour = (boolean) visit(a.etatCourant, "unicité"); // unicité des sous états
            for(Etat myStates : a.listEtat){
                for(Automate ss_aut : myStates.sousAutomates){
                    boolean tmp = (boolean)visit(ss_aut, "unicité");
                    if( retour ) retour = tmp;
                }
            }
            return retour;
        }
        if(cas.equals("determinisme")){
            // vérifie le déterminisme de l'automate courant
            boolean retour = true;
            retour = (boolean) visit(a.etatCourant, "determinisme");
            for(Etat myStates : a.listEtat){
                for(Automate ss_aut : myStates.sousAutomates){
                    boolean tmp = (boolean) visit(ss_aut, "determinisme");
                    if(retour) retour=tmp;
                }
            }
            return retour;
        }
        if(cas.equals("initial")){
            // vérifie qu'il n'y a qu'un seul état initial dans l'automate courant
            boolean retour = true;
            retour = (boolean) visit(a.etatCourant, "initial");
            for(Etat myStates : a.listEtat){
                for(Automate ss_aut : myStates.sousAutomates) {
                    boolean tmp = (boolean) visit(ss_aut, "initial");
                    if (retour) retour = tmp;
                }
            }
            return retour;
        }
        if(cas.equals("target_of_transition")){
            // vérifie que chaque état non initial est cible d'une transition
            boolean retour = true;
            for(Etat myStates : a.listEtat){
                if(!myStates.isInitial){
                    boolean tmp = (boolean) visit(myStates, "target_of_transition");
                    if(retour) retour = tmp;
                }

                for(Automate ss_aut : myStates.sousAutomates) {
                    boolean tmp = (boolean) visit(ss_aut, "target_of_transition");
                    if (retour) retour = tmp;
                }
            }
            return retour;
        }
        if (cas.equals("puits")){
            // vérifie que chaque état puit est bien un état final
            boolean retour = true;
            ArrayList<Etat> sources = new ArrayList<Etat>(a.listTransition.size());
            for(Etat myStates : a.listEtat){
                for(Transition transition : a.listTransition){
                    sources.add(transition.etatSource);
                }
            }
            for(Etat myStates : a.listEtat){
                if(!sources.contains(myStates) && !myStates.isLast){
                    retour = false;
                    System.out.println("Automate \""+a.nom+ "\":"+myStates.nom +" problème état puit.");
                }

                for(Automate ss_aut : myStates.sousAutomates) {
                    boolean tmp = (boolean) visit(ss_aut, "puits");
                    if (retour) retour = tmp;
                }
            }

            return retour;
        }

        if(cas.equals("entryPoint")){
            // point d'entré pour valider un automate
            boolean etatNonInitialEstCibleDUneTransition = true;
            boolean uniciteAutCourant = true;
            boolean determinisme = true;
            boolean oneInitialState = true;
            boolean etatPuit = true;

            uniciteAutCourant= (boolean) visit(a,"unicité");
            determinisme = (boolean) visit(a, "determinisme");
            oneInitialState = (boolean) visit(a, "initial");
            etatNonInitialEstCibleDUneTransition = (boolean) visit(a, "target_of_transition");
            etatPuit = (boolean) visit( a, "puits");

            return uniciteAutCourant && determinisme
                    && oneInitialState && etatNonInitialEstCibleDUneTransition && etatPuit;
        }
        return null;

    }

    /**
     * @see Visiteur#visit(Etat, String)
     */
    @Override
    public Object visit(Etat e, String cas) {
        if(cas.equals("unicité")){
            // vérifie que chaque état a un nom unique dans l'automate
            boolean retour=true;
            for (Etat stateOfMyAutomate : e.source.listEtat) {
                if (stateOfMyAutomate != e && stateOfMyAutomate.nom.equals(e.nom))
                {
                    System.out.println("Automate \""+e.source.nom+ "\": Deux état identique \""+e.nom+"\".");
                    retour = false;
                }
            }
            return retour;
        }

        if(cas.equals("determinisme")){
            // vérifie le déterminisme
            boolean retour = true;
            int countOfTransition = 0;
            HashSet<String> labelOfTransitions = new HashSet<String>();
            for(Transition transitionOfMyAut : e.source.listTransition)
            {
                // On compte les transition et on les ajoute dans un set. COmme c'est un set
                // si le compteur et la taille du set diffère, il y a deux transition de même label, et donc non détemriniste
                if(transitionOfMyAut.etatSource == e){
                    countOfTransition++;
                    labelOfTransitions.add((String) visit(transitionOfMyAut.etiquette, "display"));
                }
            }

            if(countOfTransition != labelOfTransitions.size())
            {
                System.out.println("Automate \""+e.source.nom+ "\": Non déterminisme.");
                retour = false;
            }
            return retour;
        }

        if(cas.equals("initial")){
            // vérifie qu'il n'y a qu'un seul état initial dans l'automate de l'état
            int compteur = 0;
            for(Etat stateOfMyAut : e.source.listEtat){
                if(stateOfMyAut.isInitial) compteur++;
            }
            if(compteur!=1){
                System.out.println("Automate \""+e.source.nom+ "\": "+compteur+" état(s) initial(ux).");
                return false;
            }
            return true;
        }

        if(cas.equals("target_of_transition")){
            // vérifie que chaque état non initial est cible d'une transition
            for(Transition t : e.source.listTransition){
                if(t.etatCible == e){
                    return true;
                }
            }
            System.out.println("Automate \""+e.source.nom+ "\":L'état \""+e.nom+"\" n'est cible d'aucune transition.");
            return false;
        }
        return e.getNom();
    }

    /**
     * @see Visiteur#visit(Transition, String)
     */
    @Override
    public Object visit(Transition t, String cas) {

        return visit(t.etiquette, "");
    }

    /**
     * @see Visiteur#visit(Label, String)
     */
    @Override
    public Object visit(Label l, String cas) {
        return l.libelle;
    }


}
