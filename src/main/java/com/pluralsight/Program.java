package com.pluralsight;

import java.util.Scanner;

public class Program {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        String playerName1 = askForText("Type player 1 name: ");
        String playerName2 = askForText("Type player 2 name: ");
        game.addPlayer(new Player(playerName1));
        game.addPlayer(new Player(playerName2));

        game.shuffleDeck();
        game.deal();
        game.playTurns();

        game.determineWinner();
    }
    // helper methods
    public static String askForText(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
}

