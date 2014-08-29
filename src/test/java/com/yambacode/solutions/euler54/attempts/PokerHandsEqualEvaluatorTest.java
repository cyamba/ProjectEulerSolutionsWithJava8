package com.yambacode.solutions.euler54.attempts;

import com.yambacode.common.io.Printer;

import static com.yambacode.solutions.euler54.poker.Hand.handWithRankValue;

import static com.yambacode.solutions.euler54.poker.Tuple.tuple;

import com.yambacode.solutions.euler54.poker.attempts.PokerHandsEqualEvaluator;

import static com.yambacode.solutions.euler54.poker.attempts.PokerRanksEvaluator.rank;

import com.yambacode.solutions.euler54.poker.io.PokerHandsReader;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-03-02.
 */
public class PokerHandsEqualEvaluatorTest {

    @Test
    public void testWinningHands() {
        //equal pairs
        PokerHandsReader.getAllPokerHandsTuples()
//                .peek(tuple -> Printer.print(tuple.toString()))
                .map(tuple -> tuple(handWithRankValue(rank(tuple._1()), 1, tuple._1().getCards()),
                        handWithRankValue(rank(tuple._2()), 2, tuple._2().getCards())))
                        //              .peek(tuple -> Printer.print(tuple.toString()))
                .filter(tuple -> tuple._1().getRank() == tuple._2().getRank())
                .forEach(tuple -> Printer.print(tuple.toString() + " --> " + PokerHandsEqualEvaluator.evaluate(tuple)));


        //test all
        PokerHandsReader.getAllPokerHandsTuples()
                .map(tuple -> tuple(handWithRankValue(rank(tuple._1()), 1, tuple._1().getCards()),
                        handWithRankValue(rank(tuple._2()), 2, tuple._2().getCards())))
                .forEach(tuple -> Printer.print(tuple.toString() + " --> " + PokerHandsEqualEvaluator.evaluate(tuple)));
    }
}
