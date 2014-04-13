package com.seewhy.common.collections;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-04-12.
 */
public class IntStreams {

    public static IntStream of(IntStream... streams) {
        return Stream.of(streams).flatMapToInt(stream -> stream);
    }

    public static IntStream tail(IntStream stream) {
        return stream.skip(1);
    }

    public static OptionalInt head(IntStream stream) {
        return stream.findFirst();
    }
}
