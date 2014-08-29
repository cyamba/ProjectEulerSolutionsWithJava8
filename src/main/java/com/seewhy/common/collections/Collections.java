package com.seewhy.common.collections;

import com.seewhy.common.io.Printer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by cbyamba on 2014-03-12.
 */
public class Collections {

    public static <T> List<T> shuffle(List<T> list) {
        List<T> newList = Lists.copy(list);
        java.util.Collections.shuffle(newList);
        return list;
    }


    public static Long[] copiesOf(Long number, int count) {
        Printer.print("upper");
        return LongStream.range(0, count).map(x -> number).boxed().toArray(x -> new Long[count]);
    }

    public static long[] copiesOf(long number, int count) {
        return LongStream.range(0, count).map(x -> number).toArray();
    }

    public static String[] copiesOf(String s, int count) {
        return IntStream.range(0, count).mapToObj(x -> s).toArray(x -> new String[count]);
    }

    @Deprecated
    public static <T> T[] copiesOf(T object, int count) {
        List<T> collect = IntStream.range(1, count).mapToObj(x -> object).collect(Collectors.toList());
        return (T[]) collect.toArray();
    }

    public static DeepCopiable[] deepCopiesOf(DeepCopiable object, int count) {
        return IntStream.range(0, count).mapToObj(x -> object.deepCopy())
                .collect(Collectors.toList())
                .toArray(object.deepCopyArray(count));
    }

    public static <T extends DeepCopiable> List<T> copiesOf(T object, int count) {
        List<T> result = IntStream.range(0, count)
                .mapToObj(x -> (T) object.deepCopy())
                .collect(Collectors.toList());
        return result;
    }

    //TODO move to a class for Collection conversions..
    public static List<Character> integerToCharacterList(List<Integer> integers) {
        return integers.stream()
                .map(x -> (char) x.intValue())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        DeepCopiable[] myStuffs = deepCopiesOf(new MyStuff(2, 3), 10);
        Printer.print(Arrays.deepToString(myStuffs));
        Printer.print(copiesOf(new MyStuff(1, 1), 10).toArray());
        Printer.print(copiesOf(Long.valueOf(10l), 10));
        Printer.print(copiesOf(10l, 10));
        Printer.print(copiesOf(new Other(55), 10));
    }

    public static List<List<Character>> copyOfNested(List<List<Character>> accu) {
        return accu.stream().map(list -> copyOf(list)).collect(Collectors.toList());
    }

    public static List<Character> copyOf(List<Character> list) {
        return list.stream().map(c -> Character.valueOf(c)).collect(Collectors.toList());
    }

    private static class MyStuff implements DeepCopiable {

        private int x;
        private int y;

        private MyStuff(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public DeepCopiable deepCopy() {
            return new MyStuff(x, y);
        }

        @Override
        public DeepCopiable[] deepCopyArray(int length) {
            return new DeepCopiable[length];
        }

        @Override
        public String toString() {
            return String.format("(%s,%s)", x, y);
        }
    }

    public static class Other {
        private int x;

        public Other(int x) {
            this.x = x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        @Override
        public String toString() {
            return "" + x;
        }
    }


}
