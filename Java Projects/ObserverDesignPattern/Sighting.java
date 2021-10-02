package ObserverDesignPattern.newpackage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adameinstein
 */
/** Keeps track of location and their details */ 
public class Sighting {
    private final String location;
    private final String details;
    public Sighting(String location,String details) {
        this.location = location;
        this.details = details;
    }
    
    public String getLocation() {
        return (this.location);
    }
    
    public String getDetails() {
        return (this.details);
    }
}