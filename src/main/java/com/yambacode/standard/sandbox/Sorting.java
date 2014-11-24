package com.yambacode.standard.sandbox;

import com.yambacode.common.io.Printer;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-09-17.
 */
public class Sorting {

    public static void main(String[] args) {
        Printer.print(insertionSort(populate(10)));
    }

    public static int[] insertionSort(int[] numbers) {
        int j;      // the number of items sorted so far
        int key;    // the item to be inserted
        int i;

        for (j = 1; j < numbers.length; j++)    // Start with 1 (not 0)
        {
            key = numbers[j]; //9
            for (i = j - 1; (i >= 0) && (numbers[i] > key); i--)   // Smaller values are moving up
            {
                numbers[i + 1] = numbers[i];//copy from right to left one position
            }
            numbers[i + 1] = key;    // Put the key in its proper location
        }
        return numbers;
    }


    public static int[] populate(int size) {
        return IntStream.range(0, size).map(x -> (int) (Math.random() * size)).toArray();
    }

}
