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

public class HomeState implements State {
    private GameConsole gConsole;

public HomeState(GameConsole gameConsole) {
    this.gConsole = gameConsole;
}

/**
* pressHomeButton: display: You are already on the home screen...
*/

@Override
public void pressHomeButton() {
    System.out.println("You are already on the home screen...");
    gConsole.setState(gConsole.getHomeState());
}

/**
* pressNintendoButton: display: Starting Nintendo...
*/
@Override
public void pressNintendoButton() {
    System.out.println("Starting Nintendo...");
    gConsole.setState(gConsole.getNintendoState());
}

/**
* pressXBoxButton: display: Starting XBox...
*/
@Override
public void pressXBoxButton() {
    System.out.println("Starting XBox...");
    gConsole.setState(gConsole.getXBoxState());
}

/**
* pressGameButton: display: You have to pick a gaming system to play.
*/
@Override
public void pressGameButton() {
    System.out.println("You have to pick a gaming system to play");
}
}
