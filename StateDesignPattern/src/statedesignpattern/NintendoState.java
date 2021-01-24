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

public class NintendoState implements State {
    private GameConsole gConsole;
    private static List<String> games;

static {
    games = new ArrayList<>();
    games.add("The Legends of Zelda");
    games.add("Super Smash Bros");
    games.add("Super Mario");
    games.add("Mario Kart");
    games.add("Animal Crossing");
    games.add("Pokemon");
}

public NintendoState(GameConsole gameConsole) {
    this.gConsole = gameConsole;
}

/**
* pressHomeButton: display: Display Home Screen...
*/
@Override
public void pressHomeButton() {
    System.out.println("Display Home Screen");
    gConsole.setState(gConsole.getHomeState());
}

/**
* pressNintendoButton: display: You are already viewing Nintendo
*/
@Override
public void pressNintendoButton() {
    System.out.println("You are already viewing Nintendo");
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
* pressGameButton: display: You have the following games:
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
