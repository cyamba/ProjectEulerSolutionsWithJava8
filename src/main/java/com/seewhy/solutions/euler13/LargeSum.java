package com.seewhy.solutions.euler13;

import com.seewhy.common.io.Printer;
import com.seewhy.solutions.AbstractEulerSolver;

import java.io.File;
import java.math.BigInteger;

import static com.seewhy.common.io.ContentReader.getContent;
import static java.util.stream.Stream.of;

/**
 * Created by cbyamba on 2014-01-14.
 */
public class LargeSum extends AbstractEulerSolver {

    private static final String PATH = "/Users/cbyamba/IdeaProjects/Java8Poc/src/com/company/euler/euler13/50numbers.eu";

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
        Printer.print(new LargeSum().solve());
    }
}
