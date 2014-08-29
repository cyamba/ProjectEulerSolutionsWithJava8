package com.yambacode.solutions.euler54.poker.attempts;

import com.yambacode.common.collections.Tuples;
import com.yambacode.solutions.euler54.poker.Card;

import static com.yambacode.solutions.euler54.poker.Hand.hand;

import com.yambacode.solutions.euler54.poker.Hand;

import com.yambacode.solutions.euler54.poker.Rank;

import static com.yambacode.solutions.euler54.poker.Tuple.tuple;

import com.yambacode.solutions.euler54.poker.Tuple;

import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.yambacode.solutions.euler54.poker.attempts.PokerRanksEvaluator.maxValue;
import static com.yambacode.solutions.euler54.poker.attempts.PokerRanksEvaluator.toStream;

/**
 * Created by cbyamba on 2014-03-01.
 */
public class PokerHandsEqualEvaluator {

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
     */
    public static Hand evaluate(Tuple<Hand, Hand> hands) {
        Rank rank = hands._1().getRank();
        switch (rank) {
            case RoyalFlush:
                return royalFlush(hands);
            case StraightFlush:
                return straightFlush(hands);
            case FourOfAKind:
                return fourOfAKind(hands);
            case FullHouse:
                return fullHouse(hands);
            case Flush:
                return flush(hands);
            case Straight:
                return straight(hands);
            case ThreeOfAKind:
                return threeOfAKind(hands);
            case TwoPairs:
                return twoPairs(hands);
            case OnePair:
                return onePair(hands);
            case HighCard:
                return highCard(hands);
            default:
                return highCard(hands);
        }
    }

    private static Hand highCard(Tuple<Hand, Hand> hands) {
        if (areMaxValueEqual(hands)) {
            Card[] firstCards = allButHighestCard(hands._1());
            Card[] secondCards = allButHighestCard(hands._2());
            return highestRemaining(hands, tuple(hand(1, firstCards), hand(2, secondCards)));
        }
        return maxValue(hands._1()) > maxValue(hands._2()) ? hands._1() : hands._2();
    }

    public static Hand highestRemaining(Tuple<Hand, Hand> handsOrig,
                                        Tuple<Hand, Hand> hands) {
        List<Tuple<Card, Card>> cardTuples = Tuples.zip(hands._1().getCards(), hands._2().getCards());
        return cardTuples.parallelStream().map(t -> Hand.hand(-1, t._1(), t._2()))
                .reduce(hands._1(),
                        (h1, h2) -> h1.getCards()[0].getValue() > h2.getCards()[0].getValue() ?
                                handsOrig._1() : handsOrig._2());
    }

    private static Card[] allButHighestCard(Hand hand) {
        return toStream(hand)
                .filter(card -> card.getValue() != maxValue(hand))
                .toArray(x -> new Card[5]);
    }

    private static boolean areMaxValueEqual(Tuple<Hand, Hand> hands) {
        return maxValue(hands._1()) == maxValue(hands._2());
    }

    private static Hand onePair(Tuple<Hand, Hand> hands) {
        if (areOnePairEqual(hands)) {
            Card[] firstCards = allButOnePair(hands._1());
            Card[] secondCards = allButOnePair(hands._2());
            return highestRemaining(hands, tuple(hand(1, firstCards), hand(2, secondCards)));
        }
        return handWithHighestPair(hands);
    }

    private static Card[] allButOnePair(Hand hand) {
        int pairValue = valueOfPair(hand);
        return toStream(hand)
                .filter(card -> card.getValue() != pairValue)
                .toArray(x -> new Card[3]);
    }

    public static Card[] allCardsButMultiplicities(Hand hand, int multiplicity) {
        int valueOfMultiplicity = valueOfMultiplicity(hand, multiplicity);
        return toStream(hand)
                .filter(card -> card.getValue() != valueOfMultiplicity)
                .toArray(x -> new Card[5 - (multiplicity - 1)]);
    }

    protected static boolean areOnePairEqual(Tuple<Hand, Hand> hands) {
        return valueOfPair(hands._1()) == valueOfPair(hands._2());
    }

    protected static int valueOfPair(Hand hand) {
        return multiplicities(hand, 2)
                .findFirst()
                .get()
                .getKey();
    }

    private static Hand twoPairs(Tuple<Hand, Hand> hands) {
        if (areHighestPairEqual(hands)) {
            if (areLowestPairEqual(hands)) {
                Card firstCard = singleCard(hands._1());
                Card secondCards = singleCard(hands._1());
                return firstCard.getValue() > secondCards.getValue() ? hands._1() : hands._2();
            }
            return handWithLowestPair(hands);
        }
        return handWithHighestPair(hands);
    }

    private static Hand handWithHighestPair(Tuple<Hand, Hand> hands) {
        return valueOfHighestPair(hands._1()) > valueOfHighestPair(hands._2()) ? hands._1() : hands._2();
    }

    protected static Hand handWithLowestPair(Tuple<Hand, Hand> hands) {
        return valueOfLowestPair(hands._1()) > valueOfPair(hands._2()) ? hands._1() : hands._2();
    }

    private static int valueOfHighestPair(Hand hand) {
        return allPairsOfHand(hand)
                .max()
                .getAsInt();
    }

    private static IntStream allPairsOfHand(Hand hand) {
        return toValueMap(hand).entrySet().parallelStream()
                .filter(e -> e.getValue().size() == 2)
                .mapToInt(e -> e.getKey());
    }

    private static int valueOfLowestPair(Hand hand) {
        return allPairsOfHand(hand)
                .min()
                .getAsInt();
    }

    private static Map<Integer, List<Card>> toValueMap(Hand hand) {
        return toStream(hand).collect(Collectors.groupingBy(Card::getValue));
    }

    private static Card singleCard(Hand hand) {
        return multiplicities(hand, 1).findFirst().get().getValue().get(0);
    }

    private static boolean areHighestPairEqual(Tuple<Hand, Hand> hands) {
        return valueOfHighestPair(hands._1()) == valueOfHighestPair(hands._2());
    }

    private static boolean areLowestPairEqual(Tuple<Hand, Hand> hands) {
        return valueOfLowestPair(hands._1()) == valueOfLowestPair(hands._2());
    }

    public static int valueOfMultiplicity(Hand hand, int k) {
        return multiplicities(hand, k)
                .findFirst()
                .get()
                .getKey();
    }

    protected static Stream<Map.Entry<Integer, List<Card>>> multiplicities(Hand hand, int k) {
        return toValueMap(hand)
                .entrySet().stream().filter(e -> e.getValue().size() == k);
    }

    private static Hand threeOfAKind(Tuple<Hand, Hand> hands) {
        if (areOfEqualThreeOfAKindValue(hands)) {
            Card[] firstCards = allCardsButMultiplicities(hands._1(), 3);
            Card[] secondCards = allCardsButMultiplicities(hands._2(), 3);
            return highestRemaining(hands, tuple(hand(1, firstCards), hand(2, secondCards)));
        }
        return handWithHighestValueForMultiplicity(hands, 3);
    }

    private static boolean areOfEqualThreeOfAKindValue(Tuple<Hand, Hand> hands) {
        return valueOfMultiplicity(hands._1(), 3) == valueOfMultiplicity(hands._2(), 3);
    }

    private static Hand straight(Tuple<Hand, Hand> hands) {
        return valueOfStraight(hands._1()) > valueOfStraight(hands._2()) ? hands._1() : hands._1();
    }

    private static int valueOfStraight(Hand hand) {
        //14,2,3,4,5
        if (PokerRanksEvaluator.isWheel(hand)) {
            return 5;
        }
        return maxValue(hand);
    }

    private static Hand flush(Tuple<Hand, Hand> hands) {
        return highestRemaining(hands, hands);
    }

    private static Hand fullHouse(Tuple<Hand, Hand> hands) {
        if (areOfEqualThreeOfAKindValue(hands)) {
            return handWithHighestPair(hands);
        }
        return handWithHighestValueForMultiplicity(hands, 3);
    }

    private static Hand fourOfAKind(Tuple<Hand, Hand> hands) {
        if (areOfEqualMultiplicityValue(hands, 4)) {
            return highestSingleCardHand(hands);
        }
        return handWithHighestValueForMultiplicity(hands, 4);
    }

    protected static Hand handWithHighestValueForMultiplicity(Tuple<Hand, Hand> hands, int multiplicty) {
        return valueOfMultiplicity(hands._1(), multiplicty) > valueOfMultiplicity(hands._2(), multiplicty) ? hands._1() : hands._2();
    }

    private static Hand highestSingleCardHand(Tuple<Hand, Hand> hands) {
        return singleCard(hands._1()).getValue() > singleCard(hands._2()).getValue() ? hands._1() : hands._2();
    }

    private static boolean areOfEqualMultiplicityValue(Tuple<Hand, Hand> hands, int multiplicity) {
        return valueOfMultiplicity(hands._1(), multiplicity) == valueOfMultiplicity(hands._2(), multiplicity);
    }

    private static Hand straightFlush(Tuple<Hand, Hand> hands) {
        return straight(hands);
    }

    private static Hand royalFlush(Tuple<Hand, Hand> hands) {
        return hands._1();
    }
}
