package com.yambacode.solutions.euler54.poker.generator;

import com.yambacode.common.io.Printer;
import com.yambacode.common.io.Serializer;
import com.yambacode.math.combinatorics.Sets;
import com.yambacode.solutions.euler54.poker.Card;
import com.yambacode.solutions.euler54.poker.Hand;
import com.yambacode.solutions.euler54.poker.Suit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-02-28.
 */
public class HandGenerator {

    public static final String pokerCachePath = "./src/main/java/com/yambacode/solutions/euler54/pokercache.y";


    public static List<Card> allCards = generateAllCards();

    public static PokerCache loadPokerCache() {
        return Serializer.serializer(pokerCachePath).read();
    }

    public static List<Card> generateAllCards() {
        return Stream.of(Suit.values())
                .flatMap(suite -> IntStream.rangeClosed(2, 14)
                        .mapToObj(value -> Card.card(value, suite.getAcronym())))
                .map(o -> (Card) o)
                .collect(Collectors.toList());
    }

    public static List<Hand> generateAllHands() {
        List<List<Integer>> subsets = Sets.subsets5(IntStream.range(0, 52).boxed().collect(Collectors.toList()));
        List<Hand> allHands = subsets.parallelStream().map(set -> createHandFromSet(set)).collect(Collectors.toList());
        return allHands;
    }

    public static Hand createHandFromSet(List<Integer> set) {
        Card[] cards = set.parallelStream().map(x -> allCards.get(x)).toArray(x -> new Card[5]);
        //Printer.print(cards);
        Hand hand = Hand.hand(-1, cards);
        Printer.print(hand.toString());
        return hand;
    }

    public static boolean writeHands() {
        long start = System.currentTimeMillis();
        Printer.print("Writing all hands to poker cache");
        Serializer.serializer(pokerCachePath).write(new PokerCache(generateAllHands()));
        long end = System.currentTimeMillis();
        Printer.print("time : " + (end - start) + " ms");
        return true;
    }

    public static void main(String[] args) {
        // writeHands();
        //Printer.print("Written down poker cache. Now try loading it..");

        /*
        Printer.print(
                Combinatorics.combinations(52,5).toString()
        );*/

        Printer.print("Loading cache...");
        long start = System.currentTimeMillis();
        //PokerCache cache = loadPokerCache();
        long end = System.currentTimeMillis();
        Printer.print("cache loaded in " + (end - start) + " ms");

        generateAllHands().parallelStream().forEach(hand -> Printer.print(hand.toString()));
    }
}
