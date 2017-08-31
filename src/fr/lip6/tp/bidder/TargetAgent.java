package fr.lip6.tp.bidder;

/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/

import fr.lip6.tp.Launcher;
import fr.lip6.tp.bidder.behaviours.RegisterScoreBehaviour;
import jade.core.behaviours.Behaviour;

//L'agent que vous allez modifier. Le score représente le nombre de fois où l'agent a acquis

public class TargetAgent extends BidderAgent {

    @Override
    public void score(Double val){
//        addBehaviour(new RegisterScoreBehaviour(computeReservePrice(getGood()), val));
    }



    @Override
    public Double computeBid(){
        /**Vous pouvez changer les fonction de calcul d'enchère et en voir l'effet.*/
        return super.computeBid();
    }

}
