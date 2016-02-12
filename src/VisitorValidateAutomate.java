import java.util.HashSet;

/**
 * Cette classe définit le corps des méthodes de visit
 */

public class VisitorValidateAutomate implements Visiteur{

    @Override
    public Object visit(Automate a, String cas) {
        if(cas.equals("unicité")){
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

        if(cas.equals("validAut")){
            boolean etatNonInitialEstCibleDUneTransition = true;
            boolean uniciteAutCourant = true;
            boolean determinisme = true;
            boolean oneInitialState = true;

            uniciteAutCourant= (boolean) visit(a,"unicité");
            determinisme = (boolean) visit(a, "determinisme");
            oneInitialState = (boolean) visit(a, "initial");
            etatNonInitialEstCibleDUneTransition = (boolean) visit(a, "target_of_transition");

            return uniciteAutCourant && determinisme && oneInitialState && etatNonInitialEstCibleDUneTransition;
        }
        return null;

    }

    @Override
    public Object visit(Etat e, String cas) {
        if(cas.equals("unicité")){
            boolean retour=true;
            // Vérifie que le nom de l'état passé en paramètre est unique parmis les autres états de son automate
            // Vérifie l'unicité des sous automates
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
            // Renvoie true si 'état courant est la cible d'une transition de son automate
            for(Transition t : e.source.listTransition)
            {
                if(t.etatCible == e){
                    return true;
                }
            }
            System.out.println("Automate \""+e.source.nom+ "\":L'état \""+e.nom+"\" n'est cible d'aucune transition.");
            return false;
        }






        return e.getNom();
    }

    @Override
    public Object visit(Transition t, String cas) {
        if(cas.equals("route")){
            visit(t.etiquette, "route");
        }
        return visit(t.etiquette, "display");
    }

    @Override
    public Object visit(Label l, String cas) {
        if(cas.equals("route")){

        }
        return l.libelle;
    }


}
