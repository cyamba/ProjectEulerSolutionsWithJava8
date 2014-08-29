package com.yambacode.solutions.euler54.poker;

/**
 * Created by cbyamba on 2014-02-22.
 */
public enum Rank {

    HighCard(1, "Highest value card"),
    OnePair(2, "Two cards of the same value"),
    TwoPairs(3, "Two different pairs"),
    ThreeOfAKind(4, "Three cards of the same value"),
    Straight(5, "All cards are consecutive values"),
    Flush(6, "All cards of the same suit"),
    FullHouse(7, "Three of a kind and a pair"),
    FourOfAKind(8, "Four cards of the same value"),
    StraightFlush(9, "All cards are consecutive values of same suit"),
    RoyalFlush(10, "Ten, Jack, Queen, King, Ace, in same suit");

    private String description;
    private int value;


    Rank(int v, String s) {
        value = v;
        description = s;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name();
    }
}
