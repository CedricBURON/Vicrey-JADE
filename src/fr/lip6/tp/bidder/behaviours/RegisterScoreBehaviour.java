package fr.lip6.tp.bidder.behaviours;
/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;

/**Cette classe doit être un OneShot Behaviour. Implémentez la méthode action() de manière à ce qu'elle incrémente
 * Launcher#score de 1 et Launcher#saved de reservePrice-val.
 */

public class RegisterScoreBehaviour{
    public RegisterScoreBehaviour(double reservePrice, double price) {
        super();
        this.reservePrice = reservePrice;
        this.price = price;
    }
    private double reservePrice;

    private double price;
}
