package fr.lip6.tp.auctioneer;

/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/
import fr.lip6.tp.auctioneer.behaviours.GoodDefinitionBehaviour;
import fr.lip6.tp.auctioneer.behaviours.ReceiveFinishingBehaviour;
import fr.lip6.tp.auctioneer.behaviours.SetupBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import fr.lip6.tp.Common;

import java.util.HashMap;
import java.util.Map;

//Agent commissaire priseur
public class AuctioneerAgent extends Agent {
    private DFAgentDescription[] bidderList;
    private Map<AID,Double> bids;
    private int registered;

    public DFAgentDescription[] getBidderList() {
        return bidderList;
    }
    @Override
    public void setup() {
        super.setup();
        bids = new HashMap<>();
        addBehaviour(new SetupBehaviour());
    }

    //Une map contenant les enchères faites par les agents enchérisseurs
    public Map<AID, Double> getBids() {
        return bids;
    }

    //Liste des enchérisseurs
    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }

    //Réinitialisation pour un nouveau bien
    public void reinitialize(){
        bids = new HashMap<>();
    }

    public AID computeWinner(){
        AID winner = bidderList[0].getName();
        Double max = Double.NEGATIVE_INFINITY;
        for(AID agent:bids.keySet()){
            if(bids.get(agent) >= max){
                max = bids.get(agent);
                winner = agent;
            }
        }
        return winner;
    }

    public Double computePrice() {
        /**Changez cette fonction en fin de TP, afin d'implémenter l'enchère de Vickrey*/
        Double max = Double.NEGATIVE_INFINITY;
        for(AID agent:bids.keySet()){
            if(bids.get(agent) >= max){
                max = bids.get(agent);
            }
        }
        return max;
    }

    public void setBidderList(DFAgentDescription[] bidderList) {
        this.bidderList = bidderList;
    }
}
