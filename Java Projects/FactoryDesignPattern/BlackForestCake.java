/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryDesignPattern;
import java.awt.Shape;
/**
 *
 * @author adameinstein
 */
public class BlackForestCake extends Cake {
    /**
     * Method to create cake type Black Forest Cake
     * With its corresponding attributes
     */
    public BlackForestCake() {

        name = "Black Forest Cake";
        price = 47.99;
        numLayers = 3;
        shape = Shape.round;
        flavor = "Black Forest";
        icing = "Whipped Cream";
        decorations.add("Cherries");
        decorations.add("Chocolate Flakes");
        decorations.add("Whipped Cream");
    }  
}
