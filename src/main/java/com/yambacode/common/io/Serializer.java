package com.yambacode.common.io;

import java.io.*;

/**
 * Created by cbyamba on 2014-02-28.
 */
public class Serializer {

    private String path;

    public Serializer(String path) {
        this.path = path;
    }

    public <T> T write(T object) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(object);
            oos.close();
            Printer.print("Done writing file..");
            return object;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T read() {
        T object = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fin);
            object = (T) ois.readObject();
            ois.close();
            Printer.print("Done loading file..");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static Serializer serializer(String path) {
        return new Serializer(path);
    }
}
