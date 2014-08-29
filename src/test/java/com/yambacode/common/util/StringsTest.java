package com.yambacode.common.util;

import com.yambacode.common.io.Printer;
import org.junit.Test;

/**
 * Created by cbyamba on 2014-04-03.
 */
public class StringsTest {

    @Test
    public void testToLetters() {
        String[] letters = Strings.toLetters("Hello");
        Printer.print(letters);
        String word = Strings.toWord(letters);
        Printer.print(word);
        
    }
}
