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
public class WeaponUpgrade extends PlayerDecorator {
    Player player;
    /**
     * Constructor
     * @param player 
     */
    public WeaponUpgrade(Player player) {
        this.player = player;
    }
    /**
     * 
     * @return toString with "\nUpgraded weapon"
     */ 
    @Override
    public String toString() {
        return player.toString() + "\nUpgraded weapon"; 
    }
    /**
     * 
     * @return getPower to Player
     */
    @Override
    public double getPower() {
        return player.getPower() + 5.0;
    }    
}
