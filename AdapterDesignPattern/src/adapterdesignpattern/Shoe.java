/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterdesignpattern;

/**
 *
 * @author adameinstein
 */
public class Shoe implements ShoeListing {
/**
 * Attributes
 */ 
    private String brand;
    private String name;
    private double cost;
    private String desc;
  
/**
 * Constructor
     * @param brand
     * @param name
     * @param price
     * @param desc
 */ 
public Shoe(String brand, String name, double price, String desc) {
    this.brand = brand;
    this.name = name;
    cost = price;
    this.desc = desc;
}
  
/** 
 * Converts Shoe Object to String
 */ 
@Override
public String toString() {
    String shoe = "";
    shoe = shoe + "Shoe: " + name ;
    shoe = shoe + "By: " + brand ;
    shoe = shoe + "Details: " + desc ;
    shoe = shoe + "Cost: $" + cost;
    return shoe;
}
}
