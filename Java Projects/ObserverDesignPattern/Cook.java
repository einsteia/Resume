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
public class Cook implements Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private final String name;
    public Cook(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(Observer observer) {
       observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

 
    public void notifyObservers(String location, String description) {
        observers.forEach((observer) -> {
            observer.update(location, description);
        });
    }
    
    /** Method called when cook is 'seen' */
    public void enterSighting(String location, String description) {
        notifyObservers(location,description); 
    }
    public String getName() {
        return (this.name);
    }
}
