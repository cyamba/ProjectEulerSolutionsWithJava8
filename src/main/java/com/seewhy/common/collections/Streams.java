package com.seewhy.common.collections;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-27.
 */
public class Streams {

    public static <T> Stream<T> of(T[]... tt) {
        return Stream.of(tt).flatMap(t -> Stream.of(t));
    }

    public static <T> Stream<T> concat(Stream<T>... streams) {
        Objects.requireNonNull(streams, "streams must be non null");
        return Stream.of(streams)
                .reduce((accu, newStream) -> Stream.concat(accu, newStream))
                .get();
    }
}
