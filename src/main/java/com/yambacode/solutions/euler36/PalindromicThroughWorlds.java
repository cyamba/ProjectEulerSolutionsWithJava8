package com.yambacode.solutions.euler36;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2011
 */
public class PalindromicThroughWorlds extends AbstractEulerSolver{
    @Override
    public String doSolve() {
        return compute().toString();
    }

    public Number compute() {
        long sum = 0;
        Integer currentPalindrome = null;
        for (int i = 1; i <= 999; i++) {

            if (DigitUtil.isPalindrome(Integer.toBinaryString(currentPalindrome = DigitUtil.palindromize(i)))) {
                sum += currentPalindrome;
            }

            if (DigitUtil.isPalindrome(Integer.toBinaryString(currentPalindrome = Integer.valueOf
                    (DigitUtil.collapseMiddleOfPalindrome(DigitUtil.palindromize(i).toString()))))) {
                sum += currentPalindrome;
            }
        }
        return currentPalindrome;
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new PalindromicThroughWorlds());
    }
}
