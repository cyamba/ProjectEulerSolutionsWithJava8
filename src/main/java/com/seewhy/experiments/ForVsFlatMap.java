package com.seewhy.experiments;

import com.seewhy.common.io.Printer;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-02-10.
 */
public class ForVsFlatMap {

    public static final int SIZE = 10;

    public static void forLoopNestedOnce() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                //System.out.print(String.format("(%s,%s) ", i, j));
            }
        }
    }

    public static void subsetsForNested() {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(String.format("(%s,%s) ", i, j));
            }
        }
    }

    public static void subsetsForMod() {
        Printer.print();
        for (int i = 0; i < SIZE * SIZE; i++) {
            System.out.print(String.format("(%s,%s) ", (SIZE + i) / SIZE, i % SIZE));
        }
    }


    private static void innerLoop(int i) {
        IntStream.range(0, SIZE).parallel().forEach(j ->
                Printer.print(String.format("(%s,%s)", i, j)));
    }

    public static void rangeFlatMap() {
        IntStream.range(0, SIZE).parallel().forEach(i -> innerLoop(i));
    }

    public static void main(String... args) {
        long start = System.currentTimeMillis();
        rangeFlatMap();
        long end = System.currentTimeMillis();
        //Printer.print("executionTime : " + (end - start) + " ms");

        long start1 = System.currentTimeMillis();
        forLoopNestedOnce();
        long end1 = System.currentTimeMillis();
        // Printer.print("executionTime : " + (end1 - start1) + " ms");

        subsetsForNested();
        subsetsForMod();
    }
}
