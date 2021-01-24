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
public class Mage extends Player {
    
    public Mage(String name) {
    /**
     * Constructors
     */        
        this.name = name;
        this.attack = 3;
        this.defense = 4;
        this.intellect = 7;
        this.weapon = "Staf";
        this.armor = "Robe";
    }
    /**
     * 
     * @return data for Mage to Player for implementation
     */
    @Override
    public String toString() {
        return "Mage: " + super.toString();
    }
}
