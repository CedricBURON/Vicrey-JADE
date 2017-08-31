package fr.lip6.tp.bidder.behaviours;
/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/
import fr.lip6.tp.Common;
import fr.lip6.tp.auctioneer.AuctioneerAgent;
import fr.lip6.tp.auctioneer.behaviours.ResultBehaviour;
import fr.lip6.tp.bidder.BidderAgent;
import fr.lip6.tp.good.Good;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiveGoodDescriptionBehaviour extends Behaviour {

    private boolean isDone;

    @Override
    public void action() {
        /**Responsabilité: recevoir les messages de type: Conversation ID = Common.GOOD_DESCRIPTION_ID ∧ Performative = INFORM
         * Si un message est reçu:
         * transformez le contenu en bien
         * donnez cette valeur au champ good de l'agent
         * ajoutez un behaviour BidBehaviour à l’agent
         */
    }

    public boolean done(){
        return isDone;
    }
}
