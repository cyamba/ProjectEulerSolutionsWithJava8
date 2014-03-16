package com.seewhy.solutions.euler54.poker.generator;

import com.seewhy.common.io.Printer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cbyamba on 2014-03-02.
 */
public class PlayerIdGenerator {
    private static AtomicInteger count = new AtomicInteger(1);

    private PlayerIdGenerator() {

    }

    public static int getId() {
        int result = count.getAndIncrement();
        return result;
    }

    public static void main(String[] args) {
        Printer.print(count.toString());
        Printer.print(getId());
        Printer.print(count.toString());
        Printer.print(getId());
        Printer.print(count.toString());
    }
}
