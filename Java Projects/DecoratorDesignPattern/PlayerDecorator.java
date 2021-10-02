/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorDesignPattern;

/** Abstract class with abstract methods
 *
 * @author adameinstein
 */
public abstract class PlayerDecorator extends Player {
    /**
     * toString = format for Players toString
     * getPower = given function to determine power level
     */
    public abstract String toString();
    public abstract double getPower();   
}
