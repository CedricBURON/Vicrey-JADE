package fr.lip6.tp.good;
/********************************************************************************
 * Universite Pierre et Marie Curie                                             *
 *                                                                              *
 * Date        Author          Changes                                          *
 * 2017-01-09  Cedric Buron    Initial version.                                 *
 ********************************************************************************/
import fr.lip6.tp.Common;
import java.util.Random;

//Classe du bien négocié
public class Good {
    private final double field1;
    private final double field2;

    //Utilisé seulement sur la description d'un bien reçue.
    private Good(double field1, double field2){
        this.field1 = field1;
        this.field2 = field2;
    }

    //Initialisation aléatoire
    public Good() {
        Random rand = Common.random;
        field1 = (rand.nextGaussian()+0.5)*0.25;
        field2 = (rand.nextGaussian()+0.5)*0.25;
    }

    public double getField1() {
        return field1;
    }

    public double getField2() {
        return field2;
    }

    //Pour transmission
    public String toString(){
        return ((Double)field1).toString() + '\n' + ((Double) field2).toString();
    }

    //Récupération du bien à partir de la chaîne créée par toString().
    public static Good parse(String strContent) {
        String[] strFields = strContent.split("\n");
        Double field1 = Double.valueOf(strFields[0]);
        Double field2 = Double.valueOf(strFields[1]);
        return new Good(field1, field2);
    }
}
