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
public class BirthdayCake extends Cake {
    /**
     * Method to create cake type 'Birthday Cake'
     * With its corresponding attributes
     */
    public BirthdayCake() {

        name = "Birthday Cake";
        price = 109.99;
        numLayers = 1;
        shape = Shape.sheet;
        flavor = "Funfetti";
        icing = "Vanilla";
        decorations.add("Sprinkles");
        decorations.add("Candy Flowers");
        decorations.add("Icing Writing"); 
    }
    
}
