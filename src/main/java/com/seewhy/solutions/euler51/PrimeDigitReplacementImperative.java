package com.seewhy.solutions.euler51;

import com.seewhy.common.util.NumberStringConversions;
import com.seewhy.math.Sets;
import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-02-20.
 */
public class PrimeDigitReplacementImperative extends AbstractEulerSolver {


    public List<Long> transformNumber(Long number, int[] positions) {
        List<Long> numbers = new ArrayList<>();
        long[] digits = NumberStringConversions.longToLongArray(number); //TODO rename to primitive suffix
        for (int i = 0; i < 10; i++) {
            long[] newDigits = Arrays.copyOf(digits, digits.length);
            for (int j = 0; j < positions.length; j++) {
                newDigits[positions[j]] = i;
            }
            long newNumber = NumberStringConversions.longArrayToLong(newDigits);
            numbers.add(newNumber);
        }
        return numbers;
    }

    public List<Long> transformNumberFunctional(Long number, int[] numbers) {
        //IntStream.range(0,10).
        return null;
    }

    @Override
    public String doSolve() {
        Set<TreeSet<Integer>> subsets = Sets.subsets(Arrays.asList(1, 2, 3, 4, 5));
        return Arrays.toString(subsets.toArray());
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PrimeDigitReplacementImperative());
    }
}
