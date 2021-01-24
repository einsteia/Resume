/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statedesignpattern;

/**
 *
 * @author adameinstein
 */
public interface State {
    
    public void pressHomeButton();

    public void pressNintendoButton();

    public void pressXBoxButton();

    public void pressGameButton();
}