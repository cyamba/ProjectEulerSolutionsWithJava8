package com.yambacode.solutions.euler4;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;

import static java.util.Comparator.*;

import static java.util.stream.IntStream.range;

/**
 * Created by cbyamba on 2014-01-10.
 */
public class LargestPalindromeProduct extends AbstractEulerSolver {

    private boolean isAnagram(String word) {
        return new StringBuilder(word).reverse().toString().equals(word);
    }

    private boolean isNDigitComposite(int number) {
        return range(99, 999)
                .mapToObj(x -> x)
                .sorted(reverseOrder())
                .anyMatch(x -> number % x == 0 && (number / x > 99 && number / x < 1000));
    }

    @Override
    public String doSolve() {
        return range(9999, 1000000)
                .parallel()
                .mapToObj(x -> x)
                .sorted(reverseOrder())
                .filter(x -> isAnagram("" + x) && isNDigitComposite(x))
                .findFirst()
                .get()
                .toString();
    }

    public static void main(String... args) {
        Printer.print(new LargestPalindromeProduct()    .solve());
    }

}
