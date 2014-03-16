package com.seewhy.solutions.euler54;

import com.seewhy.solutions.euler54.poker.Card;
import com.seewhy.solutions.euler54.poker.Hand;
import com.seewhy.solutions.euler54.poker.Rank;
import com.seewhy.solutions.euler54.poker.recursivefunction.PokerHands;
import com.seewhy.solutions.euler54.poker.recursivefunction.RankEvaluator;
import org.junit.Test;

import static java.util.Arrays.copyOfRange;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static com.seewhy.solutions.euler54.poker.Card.card;
import static com.seewhy.solutions.euler54.poker.Hand.hand;

/**
 * Created by cbyamba on 2014-02-22.
 * SHDC
 */
public class RankEvaluatorTest {
/*
    @Test
    public void testIsRoyalFlush() {
        Hand hand = hand(, newCards(card(10, 'S'), card(11, 'S'), card(12, 'S'), card(13, 'S'), card(14, 'S')));
        assertTrue(RankEvaluator.isRoyalFlush(hand));
        Hand noRoyalFlush = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertFalse(RankEvaluator.isRoyalFlush(noRoyalFlush));
    }

    @Test
    public void testEvaluateRoyalFlush() {
        Hand hand = hand(, newCards(card(10, 'S'), card(11, 'S'), card(12, 'S'), card(13, 'S'), card(14, 'S')));
        Rank actualRank = RankEvaluator.rankValueOf(hand).getRank();
        assertEquals(Rank.RoyalFlush, actualRank);
    }

    @Test
    public void testIsFourOfAKind() {
        Hand hand = hand(, newCards(card(10, 'S'), card(10, 'D'), card(10, 'S'), card(10, 'S'), card(14, 'S')));
        assertTrue(RankEvaluator.isFourOfAKind(hand));
        Hand noFourOfAKind = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertFalse(RankEvaluator.isFourOfAKind(noFourOfAKind));
    }

    @Test
    public void testEvaluateFourOfAKind() {
        Hand hand = hand(, newCards(card(11, 'S'), card(11, 'D'), card(11, 'S'), card(11, 'S'), card(14, 'S')));
        Rank actualRank = RankEvaluator.rankValueOf(hand).getRank();
        assertEquals(Rank.FourOfAKind, actualRank);
    }

    @Test
    public void testIsFullHouse() {
        Hand hand = hand(, newCards(card(10, 'S'), card(10, 'D'), card(10, 'S'), card(14, 'S'), card(14, 'S')));
        assertTrue(RankEvaluator.isFullHouse(hand));
        Hand noFullHouse = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertFalse(RankEvaluator.isFullHouse(noFullHouse));
    }

    @Test
    public void testEvaluateFullHouse() {
        Hand hand = hand(, newCards(card(10, 'S'), card(10, 'D'), card(10, 'S'), card(14, 'S'), card(14, 'S')));
        Rank actualRank = RankEvaluator.rankValueOf(hand).getRank();
        assertEquals(Rank.FullHouse, actualRank);
    }

    @Test
    public void testIsFlush() {
        Hand hand = hand(, newCards(card(10, 'D'), card(2, 'D'), card(7, 'D'), card(14, 'D'), card(14, 'D')));
        assertTrue(RankEvaluator.isFlush(hand));
        Hand noFlush = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertFalse(RankEvaluator.isFlush(noFlush));
    }

    @Test
    public void testEvaluateFlush() {
        Hand hand = hand(, newCards(card(10, 'S'), card(12, 'S'), card(10, 'S'), card(4, 'S'), card(14, 'S')));
        Rank actualRank = RankEvaluator.rankValueOf(hand).getRank();
        assertEquals(Rank.Flush, actualRank);
    }

    @Test
    public void testIsStraight() {
        Hand hand = hand(, newCards(card(6, 'H'), card(2, 'D'), card(3, 'H'), card(4, 'D'), card(5, 'D')));
        assertTrue(RankEvaluator.isStraight(hand));
        Hand notStraight = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertFalse(RankEvaluator.isStraight(notStraight));
    }

    @Test
    public void testEvaluateStraight() {
        Hand hand = hand(, newCards(card(6, 'H'), card(2, 'D'), card(3, 'H'), card(4, 'D'), card(5, 'D')));
        Rank actualRank = RankEvaluator.rankValueOf(hand).getRank();
        assertEquals(Rank.Straight, actualRank);
    }

    @Test
    public void testIsWheelStraight() {
        Hand hand = hand(, newCards(card(14, 'H'), card(2, 'D'), card(3, 'H'), card(4, 'D'), card(5, 'D')));
        assertTrue(RankEvaluator.isWheelStraight(hand));
        Hand notStraight = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertFalse(RankEvaluator.isWheelStraight(notStraight));
    }

    @Test
    public void testIsThreeOfAKind() {
        Hand hand = hand(, newCards(card(1, 'D'), card(1, 'S'), card(1, 'D'), card(2, 'H'), card(10, 'H')));
        assertTrue(RankEvaluator.isThreeOfAKind(hand));
        Hand noThreeOfAKind = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertFalse(RankEvaluator.isThreeOfAKind(noThreeOfAKind));
    }

    @Test
    public void testEvaluateThreeOfAKind() {
        Hand hand = hand(, newCards(card(1, 'D'), card(1, 'S'), card(1, 'D'), card(2, 'H'), card(10, 'H')));
        Rank actualRank = RankEvaluator.rankValueOf(hand).getRank();
        assertEquals(Rank.ThreeOfAKind, actualRank);
    }

    @Test
    public void testIsTwoPair() {
        Hand hand = hand(, newCards(card(1, 'D'), card(1, 'S'), card(2, 'D'), card(2, 'H'), card(10, 'H')));
        assertTrue(RankEvaluator.isTwoPair(hand));
        Hand noTwoPair = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertFalse(RankEvaluator.isTwoPair(noTwoPair));
    }

    @Test
    public void testEvaluateTwoPair() {
        Hand hand = hand(, newCards(card(1, 'D'), card(1, 'S'), card(2, 'D'), card(2, 'H'), card(10, 'H')));
        Rank actualRank = RankEvaluator.rankValueOf(hand).getRank();
        assertEquals(Rank.TwoPairs, actualRank);
    }

    @Test
    public void testIsOnePair() {
        Hand hand = hand(, newCards(card(1, 'D'), card(1, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertTrue(RankEvaluator.isOnePair(hand));
        Hand noPairs = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        assertFalse(RankEvaluator.isOnePair(noPairs));
    }

    @Test
    public void testEvaluateOnePair() {
        Hand hand = hand(, newCards(card(1, 'D'), card(1, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        Rank actualRank = RankEvaluator.rankValueOf(hand).getRank();
        assertEquals(Rank.OnePair, actualRank);
    }

    @Test
    public void testEvaluateHighCard() {
        Hand hand = hand(, newCards(card(1, 'D'), card(3, 'S'), card(2, 'D'), card(7, 'H'), card(10, 'H')));
        Rank actualRank = RankEvaluator.rankValueOf(hand).getRank();
        assertEquals(Rank.HighCard, actualRank);
    }

    @Test
    public void testReferenceCases() {
        assertOnHands("Pair of Fives", 0, "5H 5C 6S 7S KD 2C 3S 8S 8D TD");
        assertOnHands("Highest card Ace", 1, "5D 8C 9S JS AC 2C 5C 7D 8S QH");
        assertOnHands("Three Aces", 0, "2D 9C AS AH AC 3D 6D 7D TD QD");
        assertOnHands("Pair of Queens", 1, "4D 6S 9H QH QC 3D 6D 7H QD QS");
        assertOnHands("Highest Card Nine", 1, "2H 2D 4C 4D 4S 3C 3D 3S 9S 9D");

    }

    protected void assertOnHands(String msg, int expected, String line) {
        String[] cards = line.split(" ");
        Card[] cards1 = PokerHands.parseCards(copyOfRange(cards, 0, 5));
        Card[] cards2 = PokerHands.parseCards(copyOfRange(cards, 5, 10));
        int result = RankEvaluator.evaluate(hand(, cards1), hand(, cards2));
        assertEquals(msg, expected, result);
    }

    private Card[] newCards(Card... cards) {
        return cards;
    }
    */
}
