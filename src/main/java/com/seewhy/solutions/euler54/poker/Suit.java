package com.seewhy.solutions.euler54.poker;

import com.seewhy.common.io.Printer;

/**
 * Created by cbyamba on 2014-02-25.
 * SHDC
 */
public enum Suit {

    Spades(4, 'S', "Spades"), Hearts(3, 'H', "Hearts"), Diamonds(2, 'D', "Diamonds"), Clubs(1, 'C', "Clubs");

    private int value;
    private char acronym;
    private String description;

    Suit(int v, char a, String d) {
        value = v;
        acronym = a;
        description = d;
    }

    public int getValue() {
        return value;
    }

    public char getAcronym() {
        return acronym;
    }

    public String getDescription() {
        return description;
    }

    public static Suit valueOf(char c) {
        switch (c) {
            case 'S':
            case 's':
                return Spades;
            case 'H':
            case 'h':
                return Hearts;
            case 'D':
            case 'd':
                return Diamonds;
            case 'C':
            case 'c':
                return Clubs;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return description;
    }

    public static void main(String[] args) {
        Printer.print(valueOf('S').toString());
    }
}
