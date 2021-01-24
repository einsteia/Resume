/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IteratorDesignPattern;

import java.util.ArrayList;

/**
 * Holds the details of an item which they have to complete
 * @author adameinstein
 */
public class ToDo {
    /**
     * Corresponding attributes for ToDo
     */
    private final String title;
    private final String description;
    private final String contact;
    private final double price;
    private final ArrayList<String> supplies = new ArrayList<String>();
    /**
     * Constructor
     * @param title
     * @param description
     * @param price
     * @param contact
     * @param supplies 
     */
    public ToDo(String title, String description, double price, String contact, ArrayList<String> supplies) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.contact = contact;
    }
    /**
     * @return the price to complete the todo item
     */
    public double getPrice() {
        return price;
    }   
    /**
     * @return a string representation of 
     * title, description, contact, supply list, and price
     */
    @Override
    public String toString() {
        String str="++++++++"+ title + "+++++++++"+"\n" + description + "\n"+
                   "Business contact: " + contact + "\nSupply List:\n";
        str = supplies.stream().map((sup) -> "-" + sup + "\n").reduce(str, String::concat);
            str += "Price: $" + price;
        return str;
    }
}
        

