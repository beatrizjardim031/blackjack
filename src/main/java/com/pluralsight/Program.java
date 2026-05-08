package com.pluralsight;

import java.util.Scanner;

public class Program {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String player1 = askForText("Type player 1 name: ");
        String player2 = askForText("Type player 2 name: ");
        Deck deck = new Deck();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        deck.shuffle();

        // deal 2 cards
        for(int i = 0; i < 2; i++) {
            hand1.deal(deck.deal());
            hand2.deal(deck.deal());

        }
        int playerOneHand = hand1.getValue();
        int playerTwoHand = hand2.getValue();
        System.out.printf("%s's hand is worth %d%n", player1, playerOneHand);
        System.out.printf("%s's hand is worth %d%n", player2, playerTwoHand);

        if(playerOneHand > 21 && playerTwoHand > 21) {
            System.out.println("Oh oh, both bust!");
        } else if (playerOneHand > 21) {
            System.out.printf("Oh oh, %s BUST!%n", player1);
        } else if (playerTwoHand > 21) {
            System.out.printf("Oh oh, %s BUST!%n", player2);
        } else {
            if (playerOneHand == playerTwoHand) {
                System.out.println("CONGRATS, it's a tie... No one wins 🥲");
            } else if (playerOneHand > playerTwoHand) {
                System.out.printf("CONGRATS... %s ACTUALLY WON!!!%n", player1);
            } else {
                System.out.printf("CONGRATS... %s ACTUALLY WON!!!%n", player2);

            }
        }
    }
    // helper methods
    public static String askForText(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
}

