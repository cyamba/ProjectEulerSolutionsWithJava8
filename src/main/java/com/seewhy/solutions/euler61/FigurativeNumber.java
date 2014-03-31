package com.seewhy.solutions.euler61;

/**
 * Created by cbyamba on 2014-03-30.
 */
public class FigurativeNumber {

    private String firstTwo;
    private String lastTwo;

    private Integer value;

    public FigurativeNumber(Integer value) {
        this.value = value;
        this.firstTwo = value.toString().substring(0, 2);
        this.lastTwo = value.toString().substring(2, 4);
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

        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
