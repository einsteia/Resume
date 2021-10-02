package strategydesignpattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */
public abstract class Player {
    public String name;
    public boolean offence = true;
    DefenceBehavior defenceBehavior;
    OffenceBehavior offenceBehavior;
    
    public Player(String name) {
        this.name = name;
        setDefenceBehavior();
        setOffenceBehavior();
    }
    
    public abstract void setDefenceBehavior(); 
    
    public abstract void setOffenceBehavior();

    public String play() {
        if(offence== true)
            return offenceBehavior.play();
        else
            return defenceBehavior.play();
    }
    
    public void turnover() {
        if(offence ==true) 
            offence = false;
        else if(offence == false) 
            offence = true;
        }
}