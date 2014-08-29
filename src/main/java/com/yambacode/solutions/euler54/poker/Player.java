package com.yambacode.solutions.euler54.poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbyamba on 2014-02-22.
 */
public class Player {

    private List<Hand> hands;

    public Player(List<Hand> hands) {
        this.hands = hands;
    }

    public Player() {
        hands = new ArrayList<>();
    }

    public List<Hand> addHand(Hand hand) {
        hands.add(hand);
        return hands;
    }

    public List<Hand> getHands() {
        return hands;
    }
}
