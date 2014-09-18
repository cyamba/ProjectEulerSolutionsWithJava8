package com.yambacode.standard.mergesort;

import com.yambacode.common.io.Printer;

import java.util.stream.IntStream;

/**
 * Created by cbyamba on 2014-09-17.
 */
public class MergeSortImperative {

    public static int[] mergeSort(int[] numbers) {
        int length = numbers.length;
        if (length <= 1) {
            return numbers;
        }
        int middle = length / 2;
        int left[] = populate(numbers, 0, middle);
        int right[] = populate(numbers, middle, length);

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    protected static int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] result = new int[leftLength + rightLength];
        int leftPos = 0;
        int rightPos = 0;
        int resultPos = 0;
        while (leftPos < leftLength || rightPos < rightLength) {
            if (leftPos < leftLength && rightPos < rightLength) {
                if (left[leftPos] <= right[rightPos]) {
                    result[resultPos] = left[leftPos];
                    resultPos++;
                    leftPos++;
                } else {
                    result[resultPos] = right[rightPos];
                    resultPos++;
                    rightPos++;
                }
            } else if (leftPos < leftLength) {
                result[resultPos] = left[leftPos];
                resultPos++;
                leftPos++;
            } else if (rightPos < rightLength) {
                result[resultPos] = right[rightPos];
                resultPos++;
                rightPos++;
            }
        }
        return result;
    }

    protected static int[] populate(int[] numbers, int start, int end) {
        return IntStream.range(start, end).map(i -> numbers[i]).toArray();
    }

}
