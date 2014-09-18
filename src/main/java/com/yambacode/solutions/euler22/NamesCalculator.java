package com.yambacode.solutions.euler22;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cbyamba on 2011
 */
public class NamesCalculator extends AbstractEulerSolver {

    private List<String> sortedNames = new ArrayList<String>();

    public Number calculate() {
        //0. read from file.
        //(1. TODO read into a tree set.)
        //2. go through tree set and compute each word and multiply by its position.
        //3. return sum
        EulerReader reader = new EulerReader("./src/main/java/com/yambacode/solutions/euler22/names.txt");
        String names = reader.allNames();
        sortedNames = getAllNames(names.split(","));
        BigInteger sum = BigInteger.ZERO;
        BigInteger count = BigInteger.ONE;
        for (String name : sortedNames) {
            sum = sum.add(count.multiply(WordsUtil.getAlphabeticSum(name)));
            count = count.add(BigInteger.ONE);
        }
        return sum;

    }

    private List<String> getAllNames(String... args) {
        for (String a : args) {
            sortedNames.add(a.substring(1, a.length() - 1));
        }
        Collections.sort(sortedNames);

        return sortedNames;
    }

    @Override
    public String doSolve() {
        return calculate().toString();
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new NamesCalculator());
    }
}
