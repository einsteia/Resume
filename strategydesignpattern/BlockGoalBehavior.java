package strategydesignpattern;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**There are four options, so I set the random number 
 * generator from 0-3 and assigned each outcome to
 * a number.
 * @author adameinstein
 */

import java.util.concurrent.ThreadLocalRandom;
        
public class BlockGoalBehavior implements OffenceBehavior, DefenceBehavior {
    int min = 0;
    int max = 2;
    public String play() {
        int ran_num = ThreadLocalRandom.current().nextInt(min,max + 2);
        if(ran_num == 0)
            return "Blocks puck with stick";
        if(ran_num == 1)
            return "Blocks puck w/ knee pads";
        if(ran_num == 2)
            return "Catches the puck";
        else
            return "Hand blocks the puck";
        }
    }
