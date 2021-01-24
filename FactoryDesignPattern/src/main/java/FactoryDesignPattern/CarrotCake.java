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
public class CarrotCake extends Cake {
    /**
     * Method to create cake type Carrot Cake
     * With its corresponding attributes
     */
    public CarrotCake() {

        name = "Carrot Cake";
        price = 54.99;
        numLayers = 2;
        shape = Shape.round;
        flavor = "Carrot";
        icing = "Cream Cheese";
        decorations.add("Walnuts"); 
        decorations.add("Candy Carrots");
    }
    
}
