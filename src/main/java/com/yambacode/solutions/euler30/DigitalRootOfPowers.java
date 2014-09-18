package com.yambacode.solutions.euler30;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.util.HashSet;

/**
 * Created by cbyamba on 011-12-03
 * http://en.wikipedia.org/wiki/Narcissistic_number
 */
public class DigitalRootOfPowers extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return compute().toString();
    }

    public Number compute() {
        HashSet<Integer> numbers = new HashSet<Integer>();
        for (int i = 10; i < 999999; i++) {
            if (compute(i) != null) {
                numbers.add(i);
            }
        }
        return total(numbers);
    }

    private Integer compute(int i) {
        int sum = 0;
        for (int j = 0; j < Integer.toString(i).length(); j++) {
            sum += Math.pow(Integer.parseInt(String.valueOf(i).substring(j, j + 1)), 5);
        }
        return (sum == i) ? sum : null;
    }

    private Integer total(HashSet<Integer> numbers) {
        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new DigitalRootOfPowers());
    }
}
