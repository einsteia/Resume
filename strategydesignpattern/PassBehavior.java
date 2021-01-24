package strategydesignpattern;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adameinstein
 */
public class PassBehavior implements OffenceBehavior {
    public String play() {
        return "Passes to a forward";
    }
}
