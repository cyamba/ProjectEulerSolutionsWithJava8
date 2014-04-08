package com.seewhy.math;

import java.util.Arrays;

/**
 * Created by cbyamba on 2014-04-08.
 * Is a multipermutation
 */
public class Word {

    private Comparable[] word;

    private Word(Comparable[] word) {
        this.word = word;
    }

    public static Word of(Comparable... values) {
        return new Word(values);
    }

    public int count() {
        return word.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        if (!Arrays.deepEquals(word, word1.word)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return word != null ? Arrays.hashCode(word) : 0;
    }

    public Comparable[] get() {
        return word;
    }
}
