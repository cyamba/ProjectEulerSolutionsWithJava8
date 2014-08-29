package com.yambacode.solutions.euler54.poker.recursivefunction;


import com.yambacode.common.io.Java8Reader;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;
import com.yambacode.solutions.euler54.poker.Card;
import com.yambacode.solutions.euler54.poker.Hand;
import com.yambacode.solutions.euler54.poker.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.copyOfRange;

import static com.yambacode.solutions.euler54.poker.Card.card;
import static com.yambacode.solutions.euler54.poker.Hand.hand;
import static com.yambacode.solutions.euler54.poker.Tuple.tuple;

/**
 * Created by cbyamba on 2014-02-05.
 */
public class PokerHands extends AbstractEulerSolver {

    public static final String POKER_HANDS = "/Users/cbyamba/programming/github/EulerSolutionsWithJava8/src/main/java/com/yambacode/solutions/euler54/poker.txt";

    @Override
    public String doSolve() {

        List<Tuple<Hand, Hand>> game = new ArrayList<>();
        Java8Reader.reader(POKER_HANDS).lines().forEachOrdered(line -> parseHandsForTwoPlayers(line, game));
        return "" + game.stream()
                //.filter(handTuple -> handTuple._1().getCards().length == 5 && handTuple._2().getCards().length == 5)
                .mapToInt(handTuple -> RankEvaluator.evaluate(handTuple._1(), handTuple._2()))
                .sum();
    }

    protected void parseHandsForTwoPlayers(String line, List<Tuple<Hand, Hand>> game) {
        String[] cards = line.split(" ");
        Card[] cards1 = parseCards(copyOfRange(cards, 0, 5));
        Card[] cards2 = parseCards(copyOfRange(cards, 5, 10));
        if (cards1.length == 5 && cards2.length == 5) {
            game.add(tuple(hand(1, cards1), hand(2, cards2)));
        }
    }

    public static Card[] parseCards(String[] strCards) {
        return Stream.of(strCards)
                .map(string -> parseCardFromString(string))
                .toArray(x -> new Card[strCards.length]);
    }

    protected static Map<String, String> map = new HashMap<>();

    static {
        map.put("T", "10");
        map.put("J", "11");
        map.put("Q", "12");
        map.put("K", "13");
        map.put("A", "14");
    }

    protected static Card parseCardFromString(String string) {
        String str = string.substring(0, string.length() - 1);
        if (map.containsKey(str)) {
            str = map.get(str);
        }
        Integer value = Integer.valueOf(str);
        return card(value, string.charAt(string.length() - 1));
    }


    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PokerHands());
    }
}
