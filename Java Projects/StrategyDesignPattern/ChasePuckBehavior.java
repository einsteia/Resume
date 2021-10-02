package strategydesignpattern;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adameinstein
 */

public class ChasePuckBehavior implements DefenceBehavior {
    public String play() {
        return "Chases the puck";
    }
}
