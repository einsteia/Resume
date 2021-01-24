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

public class Product implements ProductListing {
    
/**
 * Attributes
 */ 
private String title;
private double price;
private String desc;
  
/**
 * Constructor
     * @param title
     * @param price
     * @param description
 */
public Product(String title, double price, String description) {
    this.title = title;
    this.price = price;
    this.desc = description;
}
@Override
public String getTitle() {
    return title;
}
@Override
public double getPrice() {
    return price;
}
@Override
public String getDescription() {
    return desc;
}
}