package com.yambacode.solutions.euler54;

import com.yambacode.solutions.euler54.poker.recursivefunction.EqualRankEvaluator;

/**
 * Created by cbyamba on 2014-02-26.
 */
public class EqualRankEvaluatorTest {

    private EqualRankEvaluator evaluator;

    /*
    @Test
    public void testOnePair() {
        Hand hand1 = handWithRankValue(Rank.OnePair, , card(12, 'H'), card(12, 'D'), card(14, 'H'), card(2, 'S'), card(4, 'S'));
        Hand hand2 = handWithRankValue(Rank.OnePair, , card(12, 'H'), card(12, 'D'), card(11, 'H'), card(2, 'S'), card(4, 'S'));
        int result = evaluator.evaluate(hand1, hand2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testTwoPair() {

        Hand hand1 = handWithRankValue(Rank.TwoPairs, , card(12, 'H'), card(12, 'D'), card(14, 'H'), card(14, 'S'), card(4, 'S'));
        Hand hand2 = handWithRankValue(Rank.TwoPairs, , card(13, 'S'), card(13, 'H'), card(11, 'D'), card(11, 'S'), card(4, 'S'));
        int result = evaluator.evaluate(hand1, hand2);
        Assert.assertEquals(1, result);

        //nextPair highest
        hand1 = handWithRankValue(Rank.TwoPairs, , card(12, 'H'), card(12, 'D'), card(14, 'H'), card(14, 'S'), card(4, 'S'));
        hand2 = handWithRankValue(Rank.TwoPairs, , card(12, 'S'), card(12, 'H'), card(11, 'D'), card(11, 'S'), card(4, 'S'));
        result = evaluator.evaluate(hand1, hand2);
        Assert.assertEquals(1, result);
        //single highest
        hand1 = handWithRankValue(Rank.TwoPairs, , card(12, 'H'), card(12, 'D'), card(14, 'H'), card(14, 'S'), card(13, 'S'));
        hand2 = handWithRankValue(Rank.TwoPairs, , card(12, 'S'), card(12, 'H'), card(14, 'D'), card(14, 'H'), card(4, 'S'));
        result = evaluator.evaluate(hand1, hand2);
        Assert.assertEquals(1, result);
    }
    */
}
