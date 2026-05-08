package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // fields
    private Deck deck;
    private ArrayList <Player> players;
    Scanner input = new Scanner(System.in);

    public Game() {
        this.deck = new Deck();
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void deal() {
        for(int i = 0; i < 2; i++) {
            for(Player player : players) {
                player.hit(deck);
            }
        }
    }

    public void takeTurn(Player player) {
        boolean keepPlaying = true;

        while (keepPlaying && !player.isBust()) {
            System.out.println(player.getName() + ", your hand is worth " + player.getHandValue());
            System.out.print("Feeling lucky? Do you want to Hit or Run? ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("hit")) {
                player.hit(deck);

            } else if (choice.equalsIgnoreCase("run")) {
                keepPlaying = false;

            } else {
                System.out.println("Wrong word, try again");
            }
        }
    }

    public void determineWinner() {
        if(players.get(0).getHandValue() > 21 && players.get(1).getHandValue() > 21) {
            System.out.println("Oh oh, both bust!");

        } else if (players.get(0).getHandValue() > 21) {
            System.out.printf("Oh oh, %s BUST!%n", players.get(0).getName());

        } else if (players.get(1).getHandValue() > 21) {
            System.out.printf("Oh oh, %s BUST!%n", players.get(1).getName());

        } else {
            if (players.get(0).getHandValue() == players.get(1).getHandValue()) {
                System.out.println("CONGRATS, it's a tie... No one wins 🥲");
            } else if (players.get(0).getHandValue() > players.get(1).getHandValue()) {
                System.out.printf("CONGRATS... %s ACTUALLY WON!!!%n", players.get(0).getName());
            } else {
                System.out.printf("CONGRATS... %s ACTUALLY WON!!!%n", players.get(1).getName());

            }
        }
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public void playTurns() {
        for(Player player : players) {
            takeTurn(player);
        }
    }
}
