package fr.lip6.tp.bidder;
/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/
import fr.lip6.tp.Common;
import fr.lip6.tp.bidder.behaviours.ReceiveGoodDescriptionBehaviour;
import fr.lip6.tp.good.Good;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

import java.util.Random;

//Agent encherisseur
public class BidderAgent extends Agent{

    private AID auctioneer;
    private double mult1;
    private double mult2;

    public Good getGood() {
        return good;
    }

    private Good good;

    public AID getAuctioneer() {
        return auctioneer;
    }

    @Override
    public void setup(){
        super.setup();
        declare(Common.BIDDER_TYPE, getLocalName() + Common.BIDDER_SHORT);
        try {
            //wait for Agent to be initiated
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //AID du commissaire priseur
        auctioneer = searchAuctioneer(Common.AUCTIONEER_TYPE);
        Random ran = Common.random;
        //Initialisation (aléatoire) des paramètres de l'agent
        mult1 = (ran.nextGaussian()+0.5)*0.25;
        mult2 = 1-mult1;
        //premier Behaviour
        addBehaviour(new ReceiveGoodDescriptionBehaviour());
    }

    private AID searchAuctioneer(String auctioneerType) {
        /**Déclaration des services de l'agent
         * Implémentez ici la récupération de l'AID du commissaire. Cet AID sera stocké dans auctioneer.
         */
        return null;
    }

    private void declare(String bidderType, String name) {
        /**Déclaration des services de l'agent
         * Implémentez ici la déclaration des services de l'agent. La responsabilité de cette partie de la fonction est
         * d'indiquer le type de l'agent (Common.BIDDER_TYPE) et son nom (getLocalName() + Common.BIDDER_SHORT) au DFAgent.
         */
    }


    //Caclul du prix de réserve d'un agent
    public double computeReservePrice(Good good){
        return good.getField1()*mult1 + good.getField2()*mult2;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    //Enchère à faire - Agent honnête: enchère = prix de réserve
    public Double computeBid(){
        return computeReservePrice(good);
    }

    //Réinitialisation de l'agent pour une nouvelle enchère
    public void reinitialize(){
        mult1 = (Common.random.nextGaussian()+0.5)*0.25;
        mult2 = 1-mult1;
    }

    //Seul l'agent Target (héritant de Bidder) agit et inscrit son score.
    public void score(Double val) {
    }
}
