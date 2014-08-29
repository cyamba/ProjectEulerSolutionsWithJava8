package com.yambacode.common.collections;

import com.yambacode.common.io.Printer;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-04-05.
 */
public class YStreamsTest {

    @Test
    public void testStream() {
        YStreams<Integer> ofStream = YStreams.of(1, 2, 3, 4);

        ofStream.mapIf(x -> x * x, x -> x % 2 == 0)
                .forEach(Printer::print);
    }
}
