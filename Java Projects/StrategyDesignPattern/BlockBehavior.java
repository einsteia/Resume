package strategydesignpattern;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**There are three options, so I set the random number 
 * generator from 0-2 and assigned each outcome to
 * a number.
 * @author adameinstein
 */

import java.util.concurrent.ThreadLocalRandom;
 
public class BlockBehavior implements DefenceBehavior {
    int min = 0;
    int max = 2;
    public String play() {
        int ran_num = ThreadLocalRandom.current().nextInt(min,max + 1);
        if(ran_num == 0) 
            return "Blocks player from shooting";
        if(ran_num == 1)
            return "Checks player with puck";
        else
            return "Blocks player from passing";
        }
    }