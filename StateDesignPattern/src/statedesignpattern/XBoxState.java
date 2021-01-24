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


import java.util.ArrayList;
import java.util.List;

public class XBoxState implements State {
    private GameConsole gConsole;
    private static List<String> games;

static {
    games = new ArrayList<>();
    games.add("Forza Horizon");
    games.add("Ori and the Blind Forest");
    games.add("Red Dead Redemption");
    games.add("Fortnite");
    games.add("Gears");
    games.add("Cuphead");
}

public XBoxState(GameConsole gameConsole) {
    this.gConsole = gameConsole;
}

/**
* pressHomeButton: display: Display Home Screen...
*/
@Override
public void pressHomeButton() {
System.out.println("Display Home Screen...");
gConsole.setState(gConsole.getHomeState());
}

/**
* pressNintendoButton: display: Starting Nintendo
*/
@Override
public void pressNintendoButton() {
System.out.println("Starting Nintendo...");
gConsole.setState(gConsole.getNintendoState());
}

/**
* pressXBoxButton: displays: You are already viewing XBox
*/
@Override
public void pressXBoxButton() {
System.out.println("You are already viewing XBox...");
gConsole.setState(gConsole.getXBoxState());
}

/**
* pressGameButton: display: You have the following games
* (Loop through and display the games each on their own line)
*/
@Override
public void pressGameButton() {
System.out.println("You have the following games: ");
games.forEach((game) -> {
    System.out.println(game);
        });
}
}
