/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**Goalie inherits methods from Player
 *Determines action of goalie, either defending/ attacking
 * @author adameinstein
 */
package strategydesignpattern;

public class Goalie extends Player {
    public Goalie(String name) {
    super(name); 
    }
    @Override
    
    public void setOffenceBehavior() {
            offenceBehavior = new BlockGoalBehavior();
    }
    @Override
    public void setDefenceBehavior() {
            defenceBehavior = new BlockGoalBehavior();
    }
    public String toString() {
        return (name + " plays the position: Goalie");
    }
    
}
  