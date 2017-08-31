package fr.lip6.tp;
/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/
import fr.lip6.tp.auctioneer.AuctioneerAgent;
import fr.lip6.tp.bidder.BidderAgent;
import fr.lip6.tp.bidder.TargetAgent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.domain.DFService;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import java.util.Random;

import static fr.lip6.tp.Common.NB_AGENTS;

//Classe de lancement, centralisant aussi les fonctions de score.
public class Launcher {
    private static ContainerController mainContainer;

    public static void setCounter(int counter) {
        Launcher.counter = counter;
    }

    private static int counter;
    private static int score;
    private static double saved;


    public static void end(){
        System.out.println("***************");
        System.out.println("**** Score ****");
        System.out.println(score);
        System.out.println("***************");
        //Affichage de l'économie par rapport au prix de réserve
        System.out.println("\n***************");
        System.out.println("**** Saved ****");
        System.out.println(saved);
        System.out.println("***************");
    }

    public static void launch() {
        //Launch JADE
        saved = 0.0;
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl(null, Common.PORT, null);
        profile.setParameter(DFService.DF_SEARCH_TIMEOUT_KEY, "180000");
        mainContainer = runtime.createMainContainer(profile);

        //Create master agent
        try {
            AgentController auctioneerController = mainContainer.createNewAgent(Common.AUCTIONEER_NICK, AuctioneerAgent.class.getName(), new Object[0]);
            auctioneerController.start();
        }
        catch (StaleProxyException e) {
            e.printStackTrace();
        }
        try{
            AgentController targetController = mainContainer.createNewAgent(Common.TARGET_NICK, TargetAgent.class.getName(), new Object[0]);
            targetController.start();
            AgentController[] bidderControllers = new AgentController[NB_AGENTS-1];
            for (int i = 0; i < NB_AGENTS-1; i++){
                bidderControllers[i] = mainContainer.createNewAgent(Common.BIDDER_NICK + String.format("%05d", i), BidderAgent.class.getName(), new Object[0]);
                bidderControllers[i].start();
            }
        }
        catch (StaleProxyException e) {
            e.printStackTrace();
        }
        counter = 1;
    }

    public static void main(String[] args){
        score = 0;
        Common.random = new Random(Common.SEED);
        launch();
    }

    public static void setScore(int score) {
        Launcher.score = score;
    }

    public static int getScore() {
        return score;
    }

    public static int getCounter() {
        return counter;
    }

    public static void requestEnd() {
    }

    public static double getSaved() {
        return saved;
    }

    public static void setSaved(double saved) {
        Launcher.saved = saved;
    }
}
