package com.seewhy.solutions.euler54.poker.util;

import com.seewhy.common.io.Printer;
import com.seewhy.solutions.euler54.poker.Card;
import com.seewhy.solutions.euler54.poker.Hand;
import com.seewhy.solutions.euler54.poker.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.seewhy.solutions.euler54.poker.Card.card;
import static com.seewhy.solutions.euler54.poker.Hand.hand;
import static com.seewhy.solutions.euler54.poker.Tuple.tuple;
import static java.util.Arrays.copyOfRange;

/**
 * Created by cbyamba on 2014-03-01.
 */
public class PokerHandsParser {

    protected static Map<String, String> map = new HashMap<>();

    static {
        map.put("T", "10");
        map.put("J", "11");
        map.put("Q", "12");
        map.put("K", "13");
        map.put("A", "14");
    }

    public static Tuple<Hand, Hand> parseHandsForTwoPlayers(String line) {
        String[] cards = line.split(" ");
        Card[] cards1 = parseCards(copyOfRange(cards, 0, 5));
        Card[] cards2 = parseCards(copyOfRange(cards, 5, 10));
        if (cards1.length == 5 && cards2.length == 5) {
            return tuple(hand(1, cards1), hand(2, cards2));
        }
        return null;
    }

    public static Card[] parseCards(String[] strCards) {
        return Stream.of(strCards)
                .map(string -> parseCardFromString(string))
                .toArray(x -> new Card[strCards.length]);
    }

    protected static Card parseCardFromString(String string) {
        String str = string.substring(0, string.length() - 1);
        if (map.containsKey(str)) {
            str = map.get(str);
        }
        Integer value = Integer.valueOf(str);
        return card(value, string.charAt(string.length() - 1));
    }

    public static void main(String[] args) {
        List<Tuple<Hand, Hand>> game = new ArrayList<>();
        Printer.print(parseHandsForTwoPlayers("").toString());
    }


}
