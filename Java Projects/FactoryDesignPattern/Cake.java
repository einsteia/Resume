/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryDesignPattern;

/**
 *
 * @author adameinstein
 */

import java.util.ArrayList;

public abstract class Cake {
    /**
     * Cake attributes(# = protected)
     */
    protected String name;
    protected double price;
    protected int numLayers;
    protected ArrayList<String> decorations = new ArrayList<String>();
    protected Shape shape;
    protected String flavor;
    protected String icing;
    /**
     * New empty array list for decorations of cake
     */
    public Cake() {
       decorations = new ArrayList<>(); 
    }
    /**
     * Method to establish the shapes associated with the cake
     */
    public enum Shape {
        round, sheet
    }
    /**
     * Method to assemble the cake in sequence
     */
    public void createCake() {
       createLayers();
       frostCake();
       addDecorations();
    }
    /**
     * @createLayers prints out the statement about
     * the amount of layers and shape of the type of cake
     */
    private void createLayers() {
        System.out.println("Creating a " + numLayers + " layer " + shape + " " + flavor + " cake");     
    }
    /**
     * @frostCake prints the information about which 
     * icing is used on cake type
     */
    private void frostCake() {
        System.out.println("Frost cake with "+icing+" icing.");
    }
    /**
     * @addDecorations prints the information about 
     * which decorations are added to the cake type
     */
    private void addDecorations() {
        decorations.forEach((item) -> {
            System.out.println("Adding " + item);
        });
    }
    /**
     * @return price of cake
     */
    public double getPrice() {
        return price;     
    }
}  
