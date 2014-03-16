package com.seewhy.common.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by cbyamba on 2014-01-13.
 */
public class ContentReader {

    public static String getContent(File file) {
        StringBuilder builder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                builder.append(line);
                //Printer.print(line);
                builder.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
