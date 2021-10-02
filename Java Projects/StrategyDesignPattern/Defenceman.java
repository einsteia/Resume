package strategydesignpattern;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**Inherits methods from Player
 * Defenceman probability for slapshot = 1/10
 * "            "           " Pass = 9/10
 * Incorporated random number generator to choose which 
 * action player takes
 * @author adameinstein
 */
import java.util.concurrent.ThreadLocalRandom;

public class Defenceman extends Player {
    int max = 9;
    int min = 0;
    int ran_num = ThreadLocalRandom.current().nextInt(min,max + 9);
    public Defenceman(String name) {
    super(name);
    }
    
    @Override
    public void setDefenceBehavior() {
        if(ran_num > 4)
            defenceBehavior = new ChasePuckBehavior();
        else
            defenceBehavior = new BlockGoalBehavior();
        
    }
    
    @Override
    public void setOffenceBehavior() {
        if(ran_num < 9)
            offenceBehavior = new PassBehavior();
        else
            offenceBehavior = new SlapshotBehavior();
    }
    
    public String toString() {
        return (name + " plays the position: Defenceman");
    }
    
}
