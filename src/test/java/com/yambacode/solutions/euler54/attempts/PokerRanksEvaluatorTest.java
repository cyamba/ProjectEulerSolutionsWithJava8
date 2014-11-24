package com.yambacode.solutions.euler54.attempts;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.euler54.poker.Card;
import com.yambacode.solutions.euler54.poker.Hand;
import com.yambacode.solutions.euler54.poker.Rank;
import com.yambacode.solutions.euler54.poker.attempts.PokerRanksEvaluator;
import com.yambacode.solutions.euler54.poker.io.PokerHandsReader;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static com.yambacode.solutions.euler54.poker.Card.card;
import static com.yambacode.solutions.euler54.poker.Hand.hand;
import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertTrue;

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

/**
 * Created by cbyamba on 2014-03-01.
 */
public class PokerRanksEvaluatorTest {


    //@Test
    public void testIsFlush() {

        Hand actualHand = hand(1, card(10, 's'), card(13, 's'), card(12, 's'), card(11, 's'), card(10, 's'));
        assertTrue(PokerRanksEvaluator.isFlush(actualHand));

        PokerHandsReader.getAllPokerHands()
                .filter(PokerRanksEvaluator::isFlush)
                .forEach(hand -> Printer.print(hand.toString()));
    }

    //@Test
    public void testIsRoyalflush() {

        Hand actualHand = hand(1, card(14, 's'), card(13, 's'), card(12, 's'), card(11, 's'), card(10, 's'));
        assertTrue(PokerRanksEvaluator.isRoyalFlush(actualHand));

        PokerHandsReader.getAllPokerHands()
                .filter(PokerRanksEvaluator::isRoyalFlush)
                .forEach(hand -> Printer.print(hand.toString()));
    }

   // @Test
    public void testIsStraight() {

        Hand actualHand = hand(1, card(2, 's'), card(3, 'h'), card(4, 'h'), card(5, 'h'), card(14, 'h'));
        assertTrue(PokerRanksEvaluator.isStraight(actualHand));

        PokerHandsReader.getAllPokerHands()
                .filter(PokerRanksEvaluator::isStraight)
                .forEach(hand -> Printer.print(hand.toString()));
    }

    //@Test
    public void testIsStraightFlush() {
        Hand actualHand = hand(1, card(2, 'h'), card(3, 'h'), card(4, 'h'), card(5, 'h'), card(6, 'h'));
        assertTrue(PokerRanksEvaluator.isStraightFlush(actualHand));

        PokerHandsReader.getAllPokerHands()
                .filter(PokerRanksEvaluator::isStraightFlush)
                .forEach(hand -> Printer.print(hand.toString()));
    }

   // @Test
    public void testIsFourOfAKind() {
        Hand actualHand = hand(1, card(2, 'c'), card(2, 'h'), card(2, 's'), card(2, 'h'), card(6, 'h'));
        assertTrue(PokerRanksEvaluator.isFourOfAkind(actualHand));

        PokerHandsReader.getAllPokerHands()
                .filter(PokerRanksEvaluator::isFourOfAkind)
                .forEach(hand -> Printer.print(hand.toString()));
    }

    //@Test
    public void testIsThreeOfAKind() {
        Hand actualHand = hand(1, card(2, 'c'), card(2, 'h'), card(2, 's'), card(7, 'h'), card(6, 'h'));
        assertTrue(PokerRanksEvaluator.isThreeOfAKind(actualHand));

//        PokerHandsReader.getAllPokerHands()
//                .filter(PokerRanksEvaluator::isThreeOfAKind)
//                .filter(hand -> Stream.of(hand.getCards()).mapToInt(Card::getValue).distinct().count() == 3)
//                .forEach(hand -> Printer.print(hand.toString()));
    }

    //@Test
    public void testIsTwoPairs() {
        Hand actualHand = hand(1, card(2, 'c'), card(2, 'h'), card(7, 's'), card(7, 'h'), card(6, 'h'));
        assertTrue(PokerRanksEvaluator.isTwoPairs(actualHand));

//        PokerHandsReader.getAllPokerHands()
//                .filter(PokerRanksEvaluator::isTwoPairs)
//                .forEach(hand -> Printer.print(hand.toString()));
    }

    //@Test
    public void testIsOnePair() {
        Hand actualHand = hand(1, card(2, 'c'), card(2, 'h'), card(7, 's'), card(3, 'h'), card(6, 'h'));
        assertTrue(PokerRanksEvaluator.isOnePair(actualHand));

        PokerHandsReader.getAllPokerHands()
                .filter(PokerRanksEvaluator::isOnePair)
                .forEach(hand -> Printer.print(hand.toString()));
    }

    //@Test
    public void testHighCard() {
        Hand actualHand = hand(1, card(11, 'c'), card(2, 'h'), card(7, 's'), card(3, 'h'), card(6, 'h'));
        assertTrue(PokerRanksEvaluator.isHighCard(actualHand));

//        PokerHandsReader.getAllPokerHands()
//                .filter(PokerRanksEvaluator::isHighCard)
//                .forEach(hand -> Printer.print(hand.toString()));
    }

    //@Test
    public void test() {
        Map<Integer, List<Rank>> ranks = PokerHandsReader.getAllPokerHands()
                .map(hand -> PokerRanksEvaluator.rank(hand))
                .collect(groupingBy(Rank::getValue));
        Object[] objects = ranks.entrySet().toArray();
        Set<Map.Entry<String, Long>> entries = PokerHandsReader.getAllPokerHands()
                .map(hand -> PokerRanksEvaluator.rank(hand))
                .collect(groupingBy(Rank::getName, counting()))
                .entrySet();
        Printer.print(entries.toArray());

    }

}
