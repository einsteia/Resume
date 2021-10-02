/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorDesignPattern;

/** Upgrades armor in Player classes
 *
 * @author adameinstein
 */
public class ArmorUpgrade extends PlayerDecorator {
    Player player;
    /**
     * Constructor
     * @param player 
     */
    public ArmorUpgrade(Player player) {
        this.player = player;
    }
    /**
     * 
     * @return toString with "\nUpgraded armor"
     */
    @Override
    public String toString() {
        return player.toString() + "\nUpgraded armor";
    }
    /**
     * 
     * @return getPower to Player
     */
    @Override
    public double getPower() {
        return player.getPower() + 3.0; 
    }
    
}
