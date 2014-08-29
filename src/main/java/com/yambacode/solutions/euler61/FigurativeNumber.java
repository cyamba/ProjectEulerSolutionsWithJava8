package com.yambacode.solutions.euler61;

import com.yambacode.math.Numbers;

/**
 * Created by cbyamba on 2014-03-30.
 */
public class FigurativeNumber {


    private String firstTwo;
    private String lastTwo;

    private Integer value;

    private Numbers.FigurativeType type;

    public Numbers.FigurativeType getType() {
        return type;
    }

    private FigurativeNumber(Integer value, Numbers.FigurativeType type) {
        this.value = value;
        //check(value);
        if (value.toString().length() == 4) {
            this.firstTwo = value.toString().substring(0, 2);
            this.lastTwo = value.toString().substring(2, 4);
        }
        this.type = type;
    }

    private void check(Integer value) {
        if (value.toString().length() != 4) {
            throw new IllegalArgumentException("Only 4-digit figurative numbers allowed");
        }
    }

    public static FigurativeNumber of(int value, Numbers.FigurativeType type) {
        return new FigurativeNumber(value, type);
    }

    public static FigurativeNumber of(int value) {
        return new FigurativeNumber(value, Numbers.FigurativeType.UNDEFINED);
    }

    public String getFirstTwo() {
        return firstTwo;
    }

    public String getLastTwo() {
        return lastTwo;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FigurativeNumber that = (FigurativeNumber) o;

        if (type != that.type) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    public String toStringInfo() {
        return String.format("[type : %s value : %s]", value, type.name());
    }
}
