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
public class Cartel implements Observer {
    private final Subject cook;/** Keeping track of cook */
    private final ArrayList<Sighting> sightings;
    /** 
     * Array of each sighting that keeps track of
     * location and details
     */
    public Cartel(Subject cook) {
        this.cook = cook;
        this.sightings = new ArrayList<>();
        cook.registerObserver(this);
    }

    @Override
    public void update(String location,String description) {
        sightings.add(new Sighting(location,description));
    }
     
    /** Called from Observer
     *  Displays each location as:
     *  location (description)
     */
    public String getLog() {
        String log = "";
        for(Sighting sighting:sightings) {
            log += sighting.getLocation();
            log += " ("+sighting.getDetails()+") \n";
        }
        return log;
    }
}
