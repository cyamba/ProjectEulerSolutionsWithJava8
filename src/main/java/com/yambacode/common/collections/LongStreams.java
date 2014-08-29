package com.yambacode.common.collections;

import java.util.List;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by cbyamba on 2014-03-27.
 */
public class LongStreams {

    public static LongStream concat(List<LongStream> longStreams) {
        return longStreams.stream().flatMapToLong(s -> s);

    }

    public static LongStream concat(LongStream... longStreams) {
        return Stream.<LongStream>of(longStreams)
                .reduce((accu, newStream) -> LongStream.concat(accu, newStream))
                .get();
    }
}
