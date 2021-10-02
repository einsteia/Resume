package ObserverDesignPattern.newpackage;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adameinstein
 */
public class DEA implements Observer  {
    private String notes;/** Flat String */
    private Subject cook;/** Keeping track of cook */
    private ArrayList<String> locations = new ArrayList<String>();
    /** Locations DEA have already visited */
    
    public DEA(Subject cook) {
        this.cook = cook;
        this.locations = new ArrayList<>();
        this.notes = "";
        cook.registerObserver(this);
    }

    public void update(String location, String description) {
        locations.add(location);
        this.notes += "\n" + description;
        
    }
   /**
    * Called from Observer
    * Displays the location of DEA's notes
    */
    public String getLog() {
        String log = "Locations: \n";
        for(String location:locations) {
            log += location;
            log += "\n";
        } 
        log += "Notes: ";
        log += notes;
        return log;
    }
}