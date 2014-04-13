package com.seewhy.common.collections;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-27.
 */
public class Streams {

    public static <T> Stream<T> of(T[]... tt) {
        return Stream.of(tt).flatMap(t -> Stream.of(t));
    }

    public static <T> Stream<T> of(Stream<T>... streams) {
        Objects.requireNonNull(streams, "streams must be non null");
        return Stream.of(streams)
                .reduce((accu, newStream) -> Stream.concat(accu, newStream))
                .get();
    }

    public static <T> Stream<T> tail(Stream<T> stream) {
        return stream.skip(1);
    }


    public static <T> Optional<T> head(Stream<T> stream) {
        return stream.findFirst();
    }

    public static <T> Optional<T> head(Collection<T> collection) {
        return collection.stream().findFirst();
    }

    public static <T> Stream<T> merge(T value, Stream<T> stream) {
        return Streams.of(Stream.of(value), stream);
    }

    public static <T> Stream<T> merge(Stream<T> stream, T value) {
        return Streams.of(stream, Stream.of(value));
    }

}
