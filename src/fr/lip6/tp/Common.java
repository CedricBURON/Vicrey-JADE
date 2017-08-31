package fr.lip6.tp;
/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/

import java.util.Random;

//Constantes et chaînes de caractère standard
public class Common {
    public static final String BIDDER_TYPE = "bidder";
    public static final String AUCTIONEER_TYPE = "auctioneer";
    public static final String AUCTIONEER_SHORT = "-Third";
    public static final long SEED = 0;
    public static final String GOOD_DESCRIPTION_ID = "GoodDescription";
    public static final String BID_ID = "Bid";
    public static final int NB_XP = 1000;
    public static final int PORT = 42000;
    public static final int NB_AGENTS = 20;
    public static final String AUCTIONEER_NICK = "auctioneer";
    public static final String BIDDER_NICK = "bidder";
    public static final String WINNER_ID = "Winner";
    public static final String LOSER_ID = "Loser";
    public static final String TARGET_NICK = "Target";
    public static final String BIDDER_SHORT = "-Bidder";
    public static final String FINISH_ID = "Finish";
    public static Random random;
}
