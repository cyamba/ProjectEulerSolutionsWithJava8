package com.seewhy.common.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.*;
import java.util.stream.*;

/**
 * Created by cbyamba on 2014-04-05.
 */
public class YStreams<T> implements Stream<T> {

    private Stream<T> innerStream;

    private YStreams(Stream<T> innerStream) {
        this.innerStream = innerStream;
    }

    public static <T> YStreams<T> of(T... values) {
        Stream<T> innerStream = Stream.of(values);
        return new YStreams<>(innerStream);
    }

    @Override
    public Stream<T> filter(Predicate<? super T> predicate) {
        return innerStream.filter(predicate);
    }

    @Override
    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        Stream<R> innerStream = (Stream<R>) this.innerStream.map(mapper);
        return new YStreams<>(innerStream);
    }

    @Override
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return innerStream.mapToInt(mapper);
    }

    @Override
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return innerStream.mapToLong(mapper);
    }

    @Override
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return innerStream.mapToDouble(mapper);
    }

    @Override
    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        Stream<R> flatMapStream = innerStream.flatMap(mapper);
        return new YStreams<>(flatMapStream);
    }

    @Override
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return innerStream.flatMapToInt(mapper);
    }

    @Override
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return innerStream.flatMapToLong(mapper);
    }

    @Override
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return innerStream.flatMapToDouble(mapper);
    }

    @Override
    public Stream<T> distinct() {
        Stream<T> distinctStream = this.innerStream.distinct();
        return new YStreams<>(distinctStream);
    }

    @Override
    public Stream<T> sorted() {
        Stream<T> sortedStream = this.innerStream.sorted();
        return new YStreams<>(sortedStream);
    }

    @Override
    public Stream<T> sorted(Comparator<? super T> comparator) {
        Stream<T> sortedStream = innerStream.sorted(comparator);
        return new YStreams<>(sortedStream);
    }

    @Override
    public Stream<T> peek(Consumer<? super T> action) {
        Stream<T> peekStream = innerStream.peek(action);
        return new YStreams<>(peekStream);
    }

    @Override
    public Stream<T> limit(long maxSize) {
        Stream<T> limitStream = innerStream.limit(maxSize);
        return new YStreams<>(limitStream);
    }

    @Override
    public Stream<T> skip(long n) {
        Stream<T> skipStream = innerStream.skip(n);
        return new YStreams<>(skipStream);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        innerStream.forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {
        innerStream.forEachOrdered(action);
    }

    @Override
    public Object[] toArray() {
        return innerStream.toArray();
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        return innerStream.toArray(generator);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return innerStream.reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return innerStream.reduce(accumulator);
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return innerStream.reduce(identity, accumulator, combiner);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return innerStream.collect(supplier, accumulator, combiner);
    }

    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return innerStream.collect(collector);
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        return innerStream.min(comparator);
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return innerStream.max(comparator);
    }

    @Override
    public long count() {
        return innerStream.count();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return innerStream.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return innerStream.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return innerStream.noneMatch(predicate);
    }

    @Override
    public Optional<T> findFirst() {
        return innerStream.findFirst();
    }

    @Override
    public Optional<T> findAny() {
        return innerStream.findAny();
    }

    @Override
    public Iterator<T> iterator() {
        return innerStream.iterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return innerStream.spliterator();
    }

    @Override
    public boolean isParallel() {
        return innerStream.isParallel();
    }

    @Override
    public Stream<T> sequential() {
        return innerStream.sequential();
    }

    @Override
    public Stream<T> parallel() {
        return innerStream.parallel();
    }

    @Override
    public Stream<T> unordered() {
        return innerStream.unordered();
    }

    @Override
    public Stream<T> onClose(Runnable closeHandler) {
        return innerStream.onClose(closeHandler);
    }

    @Override
    public void close() {

    }

    /**
     *
     * @param mapper function mapping from T to R
     * @param predicate filter evaluating on T
     * @param <R> generic type of returned Stream
     * @return Stream<R> a stream of type R
     */
    public <R> Stream<R> mapIf(Function<? super T, ? extends R> mapper, Predicate<? super T> predicate) {
        Stream<T> filterStream = innerStream.filter(predicate);
        Stream<R> mapIfStream = filterStream.map(mapper);
        return new YStreams(mapIfStream);
    }
}
