package com.yambacode.common.io;

import java.io.*;

/**
 * TODO use this instead of "ContentReaders"
 * Created by cbyamba on 2014-02-10.
 */
public class Java8Reader {

    public static BufferedReader reader(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }

    public static void main(String... args) {
        BufferedReader reader =
                reader("/Users/cbyamba/programming/github/EulerSolutionsWithJava8/src/main/java/com/yambacode/solutions/euler8/test.euler");

        reader.lines().forEach(Printer::print);
    }


}
