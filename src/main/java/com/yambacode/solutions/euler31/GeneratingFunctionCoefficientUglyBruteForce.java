package com.yambacode.solutions.euler31;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2011-12-03
 */
public class GeneratingFunctionCoefficientUglyBruteForce extends AbstractEulerSolver {
    @Override
    public String doSolve() {
        return compute().toString();
    }

    public Number compute() {
        int coefficient = 0;
        level1:
        for (int i = 0; i <= 200; i++)
            level2:for (int j = 0; j <= 200; j += 2)
                level3:for (int k = 0; k <= 200; k += 5)
                    level4:for (int l = 0; l <= 200; l += 10)
                        level5:for (int m = 0; m <= 200; m += 20)
                            level6:for (int n = 0; n <= 200; n += 50)
                                level7:for (int o = 0; o <= 200; o += 100)
                                    level8:for (int p = 0; p <= 200; p += 200) {
                                        if (i + j + k + l + m + n + o + p == 200) {
                                            ++coefficient;
                                            if (j == 200)
                                                continue level1;
                                            if (k == 200)
                                                continue level2;
                                            if (l == 200)
                                                continue level3;
                                            if (m == 200)
                                                continue level4;
                                            if (n == 200)
                                                continue level5;
                                            if (o == 200)
                                                continue level6;
                                        }
                                    }
        return coefficient;
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new GeneratingFunctionCoefficientUglyBruteForce());
    }

}
