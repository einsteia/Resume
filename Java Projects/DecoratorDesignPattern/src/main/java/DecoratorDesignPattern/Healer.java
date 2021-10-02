/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorDesignPattern;

/**
 *
 * @author adameinstein
 */
public class Healer extends Player {
    
    public Healer(String name) {
    /**
     * Constructors
     */        
        this.name = name;
        this.attack = 2;
        this.defense = 3;
        this.intellect = 8;
        this.weapon = "Staf";
        this.armor = "Robe";
    }
    /**
     * 
     * @return healer data for class Player for implementation
     */
    @Override
    public String toString() {
        return "Healer: " + super.toString();
    }
}

