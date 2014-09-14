package com.yambacode.solutions.euler61.newtry;

/**
 * Created by cbyamba on 2014-09-14.
 */
public class FigurativeNumber {

    private int type;
    private int value;

    private FigurativeNumber(int type, int value) {
        this.type = type;
        this.value = value;
    }

    public static FigurativeNumber of(int type, int value) {
        return new FigurativeNumber(type, value);
    }

    public int getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FigurativeNumber that = (FigurativeNumber) o;

        if (type != that.type) return false;
        if (value != that.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%s,%s]", type, value);
    }
}
