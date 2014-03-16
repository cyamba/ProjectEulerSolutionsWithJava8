package com.seewhy.solutions.euler11;

import com.sun.tools.javac.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Happy birthday E!
 * Created by cbyamba on 2014-01-14.
 */
public class ContentReaderEuler11 {

    public static int[][] getGridContent(File file) {
        HashMap<Integer, List<Integer>> gridMap = new HashMap<Integer, List<Integer>>();
        int[][] result = null;
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                int[] row = parseLine(line);
                if (result == null) {
                    result = new int[row.length][];
                }
                result[i] = row;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int[] parseLine(String line) {
        return Stream.of(line.replace("\n", "").split(" ")).mapToInt(s -> Integer.valueOf(s)).toArray();
    }
}
