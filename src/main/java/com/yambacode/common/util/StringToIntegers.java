package com.yambacode.common.util;

/**
 * Created by cbyamba on 2014-01-13.
 */
public class StringToIntegers {

    public static Integer[] convert(String str) {
        str = str.replace("\n", "");
        Integer[] result = new Integer[str.length()];
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                result[i] = Integer.parseInt(str.substring(i));
            }
            result[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        return result;
    }
}
