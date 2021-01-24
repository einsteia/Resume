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
public class Warrior extends Player {
    
    public Warrior(String name) {
    /**
     * Constructors
     */
        this.name = name;
        this.attack = 8;
        this.defense = 5;
        this.intellect = 2;
        this.weapon = "Sword";
        this.armor = "Breast Plate";
    }
    /**
     * 
     * @return data for Warrior to Player for implementation
     */    
    @Override
    public String toString() {
        return "Warrios: " + super.toString();
    }
}
