package fr.lip6.tp.bidder.behaviours;

/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/

import fr.lip6.tp.Common;
import fr.lip6.tp.Launcher;
import fr.lip6.tp.bidder.BidderAgent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import static fr.lip6.tp.Launcher.requestEnd;

public class ReceiveResultBehaviour extends Behaviour {

    private boolean isDone;

    @Override
    public void action() {
        /**Responsabilité: recevoir les messages de type: (Conversation ID = Common.WINNER_ID ∨ Conversation ID = Common.LOSER_ID) ∧ Performative = INFORM
         * Si un message est reçu:
         * si le message est gagnant, appeler la méthode score de l'agent
         * ajouter des behaviours ReceiveGoodDescriptionBehaviour et FinishedBehaviour
         * ajoutez un behaviour BidBehaviour à l’agent
         */
    }

    @Override
    public boolean done() {
        return isDone;
    }
}
