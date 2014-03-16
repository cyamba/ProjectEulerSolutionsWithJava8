package com.seewhy.solutions.euler59;

import com.seewhy.common.io.Printer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cbyamba on 2014-03-16.
 */
public class XORDecryptionTest {

    XORDecryption xorDecryption = new XORDecryption();

    @Test
    public void test() {
        List<List<Character>> lists = xorDecryption.generateKeys(3);
        String msg = Arrays.deepToString(lists.toArray());
        Printer.print(msg);
    }
}
