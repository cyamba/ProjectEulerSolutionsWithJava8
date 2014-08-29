package com.yambacode.common.collections;

import com.yambacode.common.io.Printer;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-03-16.
 */
public class MapsTest {

    @Test
    public void testInvert() {
        Map<Integer, Integer> map = IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.groupingBy(x -> negativeInverse(x)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(x -> (int) x.getKey(), y -> negativeInverse(y.getValue().get(0))));
        //Map<Integer, Integer> inverse = Maps.inverse(map);


        //Printer.print(inverse.entrySet().toArray());

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 3);
        map1.put(2, 4);
        map1.put(0, 2);
        map1.put(4, 1);
        map1.put(3, 0);
        // Map<Integer, Integer> inverse1 = Maps.inverse(map1);
        //Printer.print(inverse1.entrySet().toArray());
    }

    private int negativeInverse(int x) {
        return x + 5;
    }

    @Test
    public void test() {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 3);
        map1.put(2, 4);
        map1.put(0, 2);
        map1.put(4, 1);
        map1.put(3, 0);
        List<Integer> map1AsList = Maps.asList(map1);
        Printer.print(map1AsList.toArray());
        //Map<Integer, Integer> map2 = Maps.toMap(map1AsList.toArray(new Integer[map1AsList.size()]));
        //Printer.print(map2.entrySet().toArray());
    }
}
