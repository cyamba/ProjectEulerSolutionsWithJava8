package com.yambacode.solutions.euler54.poker.io;

import com.yambacode.common.io.Java8Reader;
import com.yambacode.solutions.euler54.poker.Hand;
import com.yambacode.solutions.euler54.poker.Tuple;
import com.yambacode.solutions.euler54.poker.recursivefunction.PokerHands;

import java.util.stream.Stream;

import static com.yambacode.solutions.euler54.poker.util.PokerHandsParser.parseHandsForTwoPlayers;

/**
 * Created by cbyamba on 2014-03-01.
 */
public class PokerHandsReader {
    public static Stream<Tuple<Hand, Hand>> getAllPokerHandsTuples() {
        return Java8Reader.reader(PokerHands.POKER_HANDS).lines().map(line -> parseHandsForTwoPlayers(line))
                .filter(handTuple -> handTuple._1().getCards().length == 5 && handTuple._2().getCards().length == 5);
    }

    public static Stream<Hand> getAllPokerHands() {
        return Java8Reader.reader(PokerHands.POKER_HANDS).lines().map(line -> parseHandsForTwoPlayers(line))
                .filter(handTuple -> handTuple._1().getCards().length == 5 && handTuple._2().getCards().length == 5)
                .flatMap(tuple -> Stream.of(tuple._1(), tuple._2()));
    }


}
