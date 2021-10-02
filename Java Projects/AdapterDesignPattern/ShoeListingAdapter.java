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
public class ShoeListingAdapter implements ProductListing {
/**
 * Attributes
 */ 
    private String title;
    private String brand;
    private double price;
    private String desc;
  
public ShoeListingAdapter(ShoeListing shoe) {
    String show = shoe.toString();
    title = show.substring(show.indexOf("Shoe:")+6, show.indexOf("By:"));
    price = Double.parseDouble(show.substring(show.indexOf("$")+1));
    brand = show.substring(show.indexOf("By:")+4, show.indexOf("Details:"));
    desc = show.substring(show.indexOf("Details:")+9, show.indexOf("Cost:"));
}

    /**
     *
     * @return title
     */
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
    return "Created by " + brand + ", " + desc;
}
}