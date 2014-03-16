package com.seewhy.solutions.euler54.poker.generator;

import com.seewhy.solutions.euler54.poker.Hand;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cbyamba on 2014-02-28.
 */
public class PokerCache implements Serializable {

    List<Hand> cardCache;

    public PokerCache(List<Hand> cardCache) {
        this.cardCache = cardCache;
    }

    public List<Hand> getCardCache() {
        return cardCache;
    }
}
