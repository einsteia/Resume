/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorDesignPattern;

/** Gives each class their methods
 *
 * @author adameinstein
 */
public abstract class Player {
    protected String name;
    protected int intellect;
    protected int defense;       
    protected int attack;
    protected String weapon;
    protected String armor;
    
    /**
     * format to print 
     * toString as instructed from directions
     */
    public String toString() {
        return name + "\nCarries a " + this.weapon + ", and wears a " + this.armor;
    }
    /**
     * Determines power level via given function
     */
    public double getPower() {
        return attack * 3 + defense + intellect/2;  
    }   
}
