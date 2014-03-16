package com.seewhy.solutions.euler54.poker.attempts;

import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;
import com.seewhy.solutions.euler54.poker.Hand;
import com.seewhy.solutions.euler54.poker.Tuple;
import com.seewhy.solutions.euler54.poker.io.PokerHandsReader;

import static com.seewhy.solutions.euler54.poker.Hand.hand;
import static com.seewhy.solutions.euler54.poker.Hand.handWithRankValue;
import static com.seewhy.solutions.euler54.poker.Tuple.tuple;
import static com.seewhy.solutions.euler54.poker.attempts.PokerRanksEvaluator.rank;

/**
 * Created by cbyamba on 2014-03-01.
 */
public class PokerHandsNew extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return "" + PokerHandsReader.getAllPokerHandsTuples()
                .map(tuple -> tuple(handWithRankValue(rank(tuple._1()), 1, tuple._1().getCards()),
                        handWithRankValue(rank(tuple._2()), 2, tuple._2().getCards())))
                .map(tuple -> isFirstWinning(tuple))
                        //.forEach(hand -> Printer.print(hand.toString()));
                .mapToInt(hand -> hand.getPlayer())
                .filter(player -> player == 1)
                .sum();
    }

    private Hand isFirstWinning(Tuple<Hand, Hand> tuple) {
        if (tuple._1().getRank() == tuple._2().getRank()) {
            return PokerHandsEqualEvaluator.evaluate(tuple);
        }
        return tuple._1().getRank().getValue() > tuple._2().getRank().getValue() ?
                tuple._1() : tuple._2();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PokerHandsNew());
    }
}
