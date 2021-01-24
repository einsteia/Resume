package statedesignpattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author adameinstein
 */
public class GameConsole {
    private State hState;
    private State nState;
    private State xState;
    private State state;

/**
* Sets state variables
* Prints "Starting up the game console"
*/

public GameConsole() {
    hState = new HomeState(this);
    nState = new NintendoState(this);
    xState = new XBoxState(this);
    System.out.println("Starting up the game console\n");
    state = hState;
}

/**
* Call states home button
*/
public void pressHomeButton() {
    state.pressHomeButton();
    System.out.println();
}

/**
* Call states Nintendo button
*/
public void pressNintendoButton() {
    state.pressNintendoButton();
    System.out.println();
}

/**
* Call states XBox button
*/
public void pressXBoxButton() {
    state.pressXBoxButton();
    System.out.println();
}

/**
* Call states Game button
*/
public void pressGameButton() {
    state.pressGameButton();
    System.out.println();
}

public State getHomeState() {
    return this.hState;
}

public State getNintendoState() {
    return this.nState;
}

public State getXBoxState() {
    return this.xState;
}

/**
 *
 * @param state
 */
public void setState(State state) {
    this.state = state;
}
}