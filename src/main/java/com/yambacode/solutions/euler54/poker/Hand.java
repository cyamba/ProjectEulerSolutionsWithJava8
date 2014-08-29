package com.yambacode.solutions.euler54.poker;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by cbyamba on 2014-02-22.
 */
public class Hand implements Serializable {
    private int player;
    private Card[] cards;
    private Rank rank;

    private Hand(Rank rank, int player, Card... cards) {
        this.rank = rank;
        this.cards = cards;
        this.player = player;
    }

    public static Hand hand(int player, Card... cs) {
        return new Hand(null, player, cs);
    }

    public static Hand handWithRankValue(Rank rankValue, int player, Card... cards) {
        return new Hand(rankValue, player, cards);
    }

    public Card[] getCards() {
        return cards;
    }

    public Rank getRank() {
        return rank;
    }

    public int getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return (rank == null) ? Arrays.toString(cards) : rank.toString() + " " + Arrays.toString(cards);
    }
}
