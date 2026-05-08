package com.pluralsight;

public class Player {
//    fields
    private String name;
    private Hand hand;

    public Player(String name) {
        this.hand = new Hand();
        this.name = name;
    }

    public int getHandValue() {
      return hand.getValue();
    }

    public boolean isBust() {
        return getHandValue() > 21;
    }

    public String getName() {
        return name;
    }

    //   action
    public void hit(Deck deck) {
        hand.deal(deck.deal());
    }

}
