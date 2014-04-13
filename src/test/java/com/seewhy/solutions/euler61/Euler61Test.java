package com.seewhy.solutions.euler61;

import com.seewhy.common.io.Printer;
import com.seewhy.math.Numbers;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-04-13.
 */
public class Euler61Test {

    private Euler61 euler61 = new Euler61();

    @Test
    public void testIsOrderN() {
        //Triangles 2775, 2850, 2926, 3003, 3081, 3160, 3240, 3321, 3403, 3486, 3570, 3655, 3741, 3828, 3916, 4005
        //Squares  1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521, 1600, 1681, 1764, 1849, 1936, 2025, 2116, 2209,

        Printer.print(Numbers.squareNumbersLessThan(1, 10000).toArray());
        Cycle cycle = Cycle.of(FigurativeNumber.of(2775, Numbers.FigurativeType.TRIANGLE),
                FigurativeNumber.of(1024, Numbers.FigurativeType.SQUARE));
        boolean orderN = euler61.isOrderN(cycle);
        Printer.print(orderN);
        boolean distinctFigurativeTypes = euler61.isDistinctFigurativeTypes(cycle);
        Printer.print(distinctFigurativeTypes);
        boolean distinct = euler61.isDistinct(cycle);
        Printer.print(distinct);
    }

}
