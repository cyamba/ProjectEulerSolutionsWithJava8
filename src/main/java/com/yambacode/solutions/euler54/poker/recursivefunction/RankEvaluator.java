package com.yambacode.solutions.euler54.poker.recursivefunction;

import com.yambacode.solutions.euler54.poker.Card;
import com.yambacode.solutions.euler54.poker.Hand;
import com.yambacode.solutions.euler54.poker.Rank;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static com.yambacode.solutions.euler54.poker.Hand.handWithRankValue;

/**
 * Created by cbyamba on 2014-02-22.
 */
public class RankEvaluator {

    /**
     * @param hand1
     * @param hand2
     * @return 1 if hand1 wins 0 if hand2 wins
     */
    public static int evaluate(Hand hand1, Hand hand2) {
        return evalueate0(rankValueOf(hand1), rankValueOf(hand2));
    }

    public static int evalueate0(Hand hand1, Hand hand2) {
        Rank rank1 = hand1.getRank();
        Rank rank2 = hand2.getRank();
        if (rank1.getValue() == rank2.getValue()) {
            return EqualRankEvaluator.evaluate(hand1, hand2);
        }
        //TODO Suits of deuce...
        return rank1.getValue() > rank2.getValue() ? 1 : 0;
    }

    public static Hand rankValueOf(Hand hand) {
        return royalFlush(hand);
    }

    public static Hand royalFlush(Hand hand) {
        return isRoyalFlush(hand) ? handWithRankValue(Rank.RoyalFlush, hand.getPlayer(), hand.getCards()) : fourOfAKind(hand);
    }

    public static boolean isRoyalFlush(Hand hand) {
        return isStraight(hand) && isFlush(hand);
    }

    public static Hand fourOfAKind(Hand hand) {
        return isFourOfAKind(hand) ? handWithRankValue(Rank.FourOfAKind, hand.getPlayer(), hand.getCards()) : fullHouse(hand);
    }

    public static boolean isFourOfAKind(Hand hand) {
        return Stream.of(hand.getCards())
                .collect(groupingBy(Card::getValue))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() == 4)
                .findAny().isPresent();
    }

    public static Hand fullHouse(Hand hand) {
        return isFullHouse(hand) ? handWithRankValue(Rank.FullHouse, hand.getPlayer(), hand.getCards()) : flush(hand);
    }

    public static boolean isFullHouse(Hand hand) {
        return isThreeOfAKind(hand) && isOnePair(hand);
    }

    public static Hand flush(Hand hand) {
        return isFlush(hand) ? handWithRankValue(Rank.Flush, hand.getPlayer(), hand.getCards()) : straight(hand);
    }

    public static boolean isFlush(Hand hand) {
        return Stream.of(hand.getCards())
                .mapToInt(Card::getSuite)
                .distinct()
                .count() == 1;
    }

    public static Hand straight(Hand hand) {
        return isStraight(hand) ? handWithRankValue(Rank.Straight, hand.getPlayer(), hand.getCards()) : threeOfAKind(hand);
    }

    /**
     * @param hand
     * @return
     */
    public static boolean isStraight(Hand hand) {
        if (isWheelStraight(hand)) {
            return true;
        }
        int[] sortedValues = Stream.of(hand.getCards()).mapToInt(Card::getValue)
                .sorted()
                .toArray();
        int length = sortedValues.length;
        int[] result = new int[length];
        IntStream.range(0, length).forEachOrdered(i -> {
            result[i] = sortedValues[i] + sortedValues[length - 1 - i];
        });
        return IntStream.of(result).distinct().count() == 1;
    }

    public static boolean isWheelStraight(Hand hand) {
        return Stream.of(hand.getCards())
                .mapToInt(Card::getValue)
                .boxed()
                .collect(toList())
                .containsAll(Arrays.asList(14, 2, 3, 4, 5));
    }

    public static Hand threeOfAKind(Hand hand) {
        return isThreeOfAKind(hand) ? handWithRankValue(Rank.ThreeOfAKind, hand.getPlayer(), hand.getCards()) : twoPair(hand);
    }

    public static boolean isThreeOfAKind(Hand hand) {
        return Stream.of(hand.getCards())
                .collect(groupingBy(Card::getValue)).entrySet().stream()
                .filter(e -> e.getValue().size() == 3)
                .findAny().isPresent();
    }

    public static Hand twoPair(Hand hand) {
        return isTwoPair(hand) ? handWithRankValue(Rank.TwoPairs, hand.getPlayer(), hand.getCards()) : onePair(hand);
    }

    public static boolean isTwoPair(Hand hand) {
        return hand.getCards().length - Stream.of(hand.getCards())
                .map(card -> card.getValue())
                .distinct()
                .count() == 2;
    }

    public static Hand onePair(Hand hand) {
        return isOnePair(hand) ? handWithRankValue(Rank.OnePair, hand.getPlayer(), hand.getCards()) : highCard(hand);
    }

    public static boolean isOnePair(Hand hand) {
        return Stream.of(hand.getCards())
                .collect(groupingBy(Card::getValue))
                .entrySet()
                .stream()
                .anyMatch(e -> e.getValue().size() == 2);
    }

    public static Hand highCard(Hand hand) {
        return handWithRankValue(Rank.HighCard, hand.getPlayer(), hand.getCards());
    }

}
