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
public class Skill extends PlayerDecorator {
    Player player;
    /**
     * Constructor
     * @param player 
     */
    public Skill(Player player) {
        this.player = player;
    }
    /**
     * 
     * @return toString with "\nGained a skill"
     */
    @Override
    public String toString() {
       return player.toString() + "\nGained a skill"; 
    }
     /**
     * 
     * @return getPower to Player
     */
    @Override
    public double getPower() {
       return player.getPower() + 2.0;
    }
}
