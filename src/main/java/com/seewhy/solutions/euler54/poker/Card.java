package com.seewhy.solutions.euler54.poker;

import java.io.Serializable;

/**
 * Created by cbyamba on 2014-02-22.
 */
public class Card implements Serializable{
    private Integer value;
    private char suite;

    private Card(int value, char suite) {
        this.value = value;
        this.suite = suite;
    }

    public static Card card(int value, char suite) {
        return new Card(value, suite);
    }

    public Integer getValue() {
        return value;
    }

    public char getSuite() {
        return suite;
    }

    public Suit getSuitEnum() {
        return Suit.valueOf(suite);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suite != card.suite) return false;
        if (value != null ? !value.equals(card.value) : card.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (int) suite;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s%s", value, suite);
    }
}
