/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategydesignpattern;

/** Inherits methods from Player
 * Forward has either two actions in which I applied a 
 * random value to generate(Chase/Block) 
 *
 * 
 * @author adameinstein
 */
import java.util.concurrent.ThreadLocalRandom;

public class Forward extends Player {
    int max = 1;
    int min = 0;
    int ran_num = ThreadLocalRandom.current().nextInt(min,max + 1);
    public Forward(String name) {
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
            offenceBehavior = new ShootBehavior();
    }
    
    public String toString() {
        return (name + " plays the position: Forward");
    }
    
}

