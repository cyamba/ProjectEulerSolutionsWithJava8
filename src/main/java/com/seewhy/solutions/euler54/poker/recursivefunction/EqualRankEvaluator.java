package com.seewhy.solutions.euler54.poker.recursivefunction;

import com.seewhy.common.io.Printer;
import com.seewhy.solutions.euler54.poker.Card;
import com.seewhy.solutions.euler54.poker.Hand;
import com.seewhy.solutions.euler54.poker.Rank;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-02-26.
 */
public class EqualRankEvaluator {

    /**
     * HighCard(1, "Highest value card"),
     * OnePair(2, "Two cards of the same value"),
     * TwoPairs(3, "Two different pairs"),
     * ThreeOfAKind(4, "Three cards of the same value"),
     * Straight(5, "All cards are consecutive values"),
     * Flush(6, "All cards of the same suit"),
     * FullHouse(7, "Three of a kind and a pair"),
     * FourOfAKind(8, "Four cards of the same value"),
     * StraightFlush(9, "All cards are consecutive values of same suit"),
     * RoyalFlush(10, "Ten, Jack, Queen, King, Ace, in same suit");
     *
     * @param hand1
     * @param hand2
     * @return
     */
    public static int evaluate(Hand hand1, Hand hand2) {
        Rank rank = hand1.getRank();
        switch (rank) {
            case HighCard:
                return highCard(hand1, hand2);
            case OnePair:
                return onePair(hand1, hand2);
            case TwoPairs:
                return twoPairs(hand1, hand2);
            case ThreeOfAKind:
                return threeOfAKind(hand1, hand2);
            case FourOfAKind:
                return fourOfAKind(hand1, hand2);
            case Straight:
                return straight(hand1, hand2);
            case FullHouse:
                return fullHouse(hand1, hand2);
            case Flush:
                return flush(hand1, hand2);
            case StraightFlush:
                return straightFlush(hand1, hand2);
            case RoyalFlush:
                return royalFlush(hand1, hand2);
        }
        return 0;
    }

    protected static int highCard(Hand hand1, Hand hand2) {
        return evaluate(highestCardOfGivenCardinality(hand1, 1), highestCardOfGivenCardinality(hand2, 1));
    }

    protected static int twoPairs(Hand hand1, Hand hand2) {
        int highestPair1 = highestCardOfGivenCardinality(hand1, 2);
        int highestPair2 = highestCardOfGivenCardinality(hand2, 2);
        if (highestPair1 == highestPair2) {
            Card[] cards1 = filterHighestPair(hand1, highestPair1);
            Card[] cards2 = filterHighestPair(hand2, highestPair1);
            int highestNextPair1 = highestCardOfGivenCardinality(Hand.hand(1, cards1), 2);
            int highestNextPair2 = highestCardOfGivenCardinality(Hand.hand(2, cards2), 2);
            if (highestNextPair1 == highestNextPair2) {
                return evaluate(highestCardOfGivenCardinality(hand1, 1), highestCardOfGivenCardinality(hand2, 1));
            }
            return evaluate(highestNextPair1, highestNextPair2);
        }
        return evaluate(highestPair1, highestPair2);
    }

    protected static int highestCardOfGivenCardinality(Hand hand, int cardinality) {
        return Stream.of(hand.getCards())
                .collect(groupingBy(Card::getValue))
                .entrySet().stream()
                .filter(e -> e.getValue().size() == cardinality)
                .mapToInt(e -> e.getKey())
                .max()
                .getAsInt();
    }

    protected static Card[] filterHighestPair(Hand hand, int highestPair1) {
        return Stream.of(hand.getCards())
                .filter(card -> card.getValue() != highestPair1)
                .toArray(x -> new Card[hand.getCards().length - 2]);
    }

    protected static int threeOfAKind(Hand hand1, Hand hand2) {
        int highestThree1 = highestCardOfGivenCardinality(hand1, 3);
        int highestThree2 = highestCardOfGivenCardinality(hand2, 3);
        if (highestThree1 == highestThree2) {
            int highestSingle1 = highestCardOfGivenCardinality(hand1, 1);
            int highestSingle2 = highestCardOfGivenCardinality(hand2, 1);
            return evaluate(highestSingle1, highestSingle2);
        }
        return evaluate(highestThree1, highestThree2);
    }

    protected static int straight(Hand hand1, Hand hand2) {
        return evaluate(max(hand1), max(hand2));
    }

    protected static int flush(Hand hand1, Hand hand2) {
        return evaluate(max(hand1), max(hand2));
    }

    protected static int fullHouse(Hand hand1, Hand hand2) {
        int highestThree1 = highestCardOfGivenCardinality(hand1, 3);
        int highestThree2 = highestCardOfGivenCardinality(hand2, 3);
        if (highestThree1 == highestThree2) {
            return evaluate(highestCardOfGivenCardinality(hand1, 2), highestCardOfGivenCardinality(hand2, 2));
        }
        return evaluate(highestThree1, highestThree2);
    }

    /**
     * compare highest four then kicker
     */
    protected static int fourOfAKind(Hand hand1, Hand hand2) {
        Integer highestFour1 = highestCardOfGivenCardinality(hand1, 4);
        Integer highestFour2 = highestCardOfGivenCardinality(hand2, 4);
        if (highestFour1 == highestFour2) {
            return evaluate(highestCardOfGivenCardinality(hand1, 1), highestCardOfGivenCardinality(hand2, 1));
        }
        return evaluate(highestFour1, highestFour2);
    }

    protected static int straightFlush(Hand hand1, Hand hand2) {
        return evaluate(max(hand1), max(hand2));
    }

    protected static int royalFlush(Hand hand1, Hand hand2) {
        Printer.print(String.format("Both have royal flush! hand1 : %s hand2 : %s", hand1, hand2));
        return 0;
    }

    public static int onePair(Hand hand1, Hand hand2) {
        int value1 = highestCardOfGivenCardinality(hand1, 2);
        int value2 = highestCardOfGivenCardinality(hand2, 2);
        if (value1 == value2) {
            return evaluate(highestCardOfGivenCardinality(hand1, 1), highestCardOfGivenCardinality(hand2, 1));
        }
        return evaluate(value1, value2);
    }

    protected static int max(Hand hand) {
        return Stream.of(hand.getCards())
                .mapToInt(Card::getValue)
                .max()
                .orElse(0);
    }

    protected static int evaluate(int first, int second) {
        return first > second ? 1 : 0;
    }

}
