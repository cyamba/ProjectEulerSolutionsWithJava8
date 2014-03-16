package com.seewhy.solutions.euler54.poker.attempts;

import com.seewhy.solutions.euler54.poker.Card;
import com.seewhy.solutions.euler54.poker.Hand;
import com.seewhy.solutions.euler54.poker.Rank;
import com.seewhy.solutions.euler54.poker.Suit;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Created by cbyamba on 2014-03-01.
 */
public class PokerRanksEvaluator {

    /*
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
     */

    public static Hand handWithRank(Hand hand) {
        return Hand.handWithRankValue(rank(hand), hand.getPlayer(), hand.getCards());
    }

    public static Rank rank(Hand hand) {
        return royalFlush(hand);
    }

    public static Rank royalFlush(Hand hand) {
        return isRoyalFlush(hand) ? Rank.RoyalFlush : straightFlush(hand);
    }

    public static boolean isRoyalFlush(Hand hand) {
        boolean isRoyal = toStream(hand).mapToInt(card -> card.getValue()).sum() == 14 + 13 + 12 + 11 + 10;
        return isStraightFlush(hand) && isRoyal;
    }

    public static Rank straightFlush(Hand hand) {
        return isStraight(hand) ? Rank.Straight : fourOfAKind(hand);
    }

    public static boolean isStraightFlush(Hand hand) {
        return isStraight(hand) && isFlush(hand);
    }

    public static boolean isFlush(Hand hand) {
        Suit suit = hand.getCards()[0].getSuitEnum();
        return toStream(hand).allMatch(card -> card.getSuitEnum() == suit);
    }

    public static boolean isStraight(Hand hand) {
        //3,4,5,6,7
        int length = hand.getCards().length;
        boolean isDistinct = toStream(hand).mapToInt(Card::getValue).distinct().count() == length;
        boolean hasCorrectRangeSpan = maxValue(hand) - minValue(hand) == length - 1;
        return isWheel(hand) || (isDistinct && hasCorrectRangeSpan);
    }

    public static boolean isWheel(Hand hand) {
        List<Integer> cards = toStream(hand).mapToInt(Card::getValue).boxed().collect(toList());
        return cards.containsAll(IntStream.of(14, 2, 3, 4, 5).boxed().collect(toList()));
    }

    public static Rank fourOfAKind(Hand hand) {
        return hasFourOfAkind(hand) ? Rank.FourOfAKind : fullHouse(hand);
    }

    public static Rank fullHouse(Hand hand) {
        return isFullHouse(hand) ? Rank.FullHouse : flush(hand);
    }

    private static Rank flush(Hand hand) {
        return isFlush(hand) ? Rank.Flush : straight(hand);
    }

    private static Rank straight(Hand hand) {
        return isStraight(hand) ? Rank.Straight : threeOfAKind(hand);
    }

    public static Rank threeOfAKind(Hand hand) {
        return isThreeOfAKind(hand) ? Rank.ThreeOfAKind : twoPairs(hand);
    }

    public static Rank twoPairs(Hand hand) {
        return isTwoPairs(hand) ? Rank.TwoPairs : onePair(hand);
    }

    public static boolean isTwoPairs(Hand hand) {
        return hasTwoPairs(hand) && numberOfDistinctValues(hand) == 3;
    }

    protected static boolean hasTwoPairs(Hand hand) {
        return toStream(hand)
                .collect(groupingBy(Card::getValue))
                .entrySet().stream()
                .filter(e -> e.getValue().size() == 2)
                .count() == 2;
    }

    public static Rank onePair(Hand hand) {
        return isOnePair(hand) ? Rank.OnePair : highCard(hand);
    }

    public static boolean isHighCard(Hand hand) {
        return toStream(hand).mapToInt(Card::getValue).distinct().count() == 5;
    }

    public static Rank highCard(Hand hand) {
        return Rank.HighCard;
    }

    public static boolean isOnePair(Hand hand) {
        return hasPair(hand) && numberOfDistinctValues(hand) == 4;
    }

    private static int numberOfDistinctValues(Hand hand) {
        return (int) toStream(hand)
                .collect(groupingBy(Card::getValue))
                .entrySet().stream()
                .mapToInt(e -> e.getKey())
                .distinct()
                .count();

    }

    public static boolean isThreeOfAKind(Hand hand) {
        return hasThreeOfAKind(hand) && numberOfDistinctValues(hand) == 3;
    }

    public static boolean hasThreeOfAKind(Hand hand) {
        return hasMultiplicity(hand, 3);
    }

    public static boolean hasMultiplicity(Hand hand, int k) {
        return toStream(hand)
                .collect(groupingBy(Card::getValue))
                .entrySet().stream()
                .anyMatch(e -> e.getValue().size() == k);
    }

    public static boolean isFullHouse(Hand hand) {
        return hasPair(hand) && hasFourOfAkind(hand);
    }

    public static boolean hasPair(Hand hand) {
        return hasMultiplicity(hand, 2);
    }

    public static boolean isFourOfAkind(Hand hand) {
        return hasFourOfAkind(hand) && numberOfDistinctValues(hand) == 2;
    }

    public static boolean hasFourOfAkind(Hand hand) {
        return hasMultiplicity(hand, 4);
    }

    public static Stream<Card> toStream(Hand hand) {
        return Stream.of(hand.getCards());
    }

    public static int maxValue(Hand hand) {
        return toStream(hand).mapToInt(Card::getValue).max().getAsInt();
    }

    public static int minValue(Hand hand) {
        return toStream(hand).mapToInt(Card::getValue).min().getAsInt();
    }

    public static void main(String[] args) {

    }

}
