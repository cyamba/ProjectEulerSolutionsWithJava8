package com.yambacode.solutions.euler22;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cbyamba on 2014-09-18.
 */
public class EulerReader {

    private String fileName;

    private String allNames;

    public EulerReader(String fileName) {
        this.fileName = fileName;
    }

    public String allNames() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            allNames = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allNames;
    }


}

