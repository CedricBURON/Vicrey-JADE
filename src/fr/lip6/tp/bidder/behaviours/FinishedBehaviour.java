package fr.lip6.tp.bidder.behaviours;
/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/
import fr.lip6.tp.Common;
import fr.lip6.tp.bidder.BidderAgent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class FinishedBehaviour extends OneShotBehaviour {
    @Override
    public void action() {
        /**Responsabilité: Envoyer un message dont:
         * le performatif est ACLMessage.INFORM
         * l'identifiant de la conversation est Common.FINISH_ID
         * le destinataire est le commissaire priseur.
         */
        ((BidderAgent) myAgent).reinitialize();
    }
}
