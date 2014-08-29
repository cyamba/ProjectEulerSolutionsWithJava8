package com.yambacode.experiments.bracelet;

import java.util.Arrays;

/**
 * Created by cbyamba on 2014-08-29.
 */
public class Bracelet {

    private String[] pearls;

    private Bracelet(String[] pearls) {
        this.pearls = pearls;
    }

    public static Bracelet of(String... pearls) {
        return new Bracelet(pearls);
    }

    public String[] getPearls() {
        return pearls;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        String[] otherPearls = ((Bracelet) other).getPearls();
        if (otherPearls == null) {
            return false;
        }
        return Pearls.flattenedEquals(pearls, otherPearls);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pearls);
    }

}
