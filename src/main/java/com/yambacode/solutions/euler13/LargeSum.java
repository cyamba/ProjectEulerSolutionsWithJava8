package com.yambacode.solutions.euler13;

import com.yambacode.common.io.Printer;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

import java.io.File;
import java.math.BigInteger;

import static com.yambacode.common.io.ContentReader.getContent;
import static java.util.stream.Stream.of;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class LargeSum extends AbstractEulerSolver {

    private static final String PATH = "./src/main/java/com/yambacode/solutions/euler13/50numbers.eu";

    private static File file = new File(PATH);

    //TODO FIX
    @Override
    public String doSolve() {
        String[] content = getContent(file).split("\n");
        return of(content)
                .map(s -> new BigInteger(s))
                .reduce((x, y) -> x.multiply(y))
                .get()
                .toString();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new LargeSum());
    }
}
