package strategydesignpattern;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adameinstein
 */
public class SlapshotBehavior implements OffenceBehavior {
    public String play() {
       return "Shoots the puck from the blue line";
    }
}
