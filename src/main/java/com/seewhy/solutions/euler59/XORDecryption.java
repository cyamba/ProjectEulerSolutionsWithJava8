package com.seewhy.solutions.euler59;

import com.seewhy.common.collections.CollectionBlocks;
import com.seewhy.common.collections.Collections;
import com.seewhy.common.collections.Lists;
import com.seewhy.common.io.Java8Reader;
import com.seewhy.common.io.Printer;
import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by cbyamba on 2014-03-07.
 */
public class XORDecryption extends AbstractEulerSolver {

    private static final int KEY_LENGTH = 3;

    public static final String TEST = "";

    public static final String CIPHER = "/Users/cbyamba/programming/github/EulerSolutionsWithJava8" +
            "/src/main/java/com/seewhy/solutions/euler59/cipher1.txt";

    private static final String DICTIONARY = "/Users/cbyamba/programming/github/EulerSolutionsWithJava8" +
            "/src/main/java/com/seewhy/solutions/euler59/words_remove_before_commit";

    private static final List<Character> ALPHABET = Collections.integerToCharacterList(
            IntStream.range(97, 97 + 26)
                    .boxed()
                    .collect(toList()));

    private static final List<String> dictionaryWords = Java8Reader.reader(DICTIONARY)
            .lines()
            .map(line -> line.trim())
            .collect(Collectors.toList());

    @Override
    public String doSolve() {

        List<List<Character>> allKeys = generateKeys(KEY_LENGTH);
        List<List<String>> wordBlocksOf3 = CollectionBlocks.toBlockList(getCipherStream().collect(toList()), 3);
        List<List<Character>> mutableKeys = Lists.newArrayList();

        final List<List<String>> answer = Lists.newArrayList();
        allKeys.stream().forEach(key -> {
            try {
                List<String> words = terminateIfDone(decipher(key, wordBlocksOf3));
                if (words != null) {
                    answer.add(words);
                    throw new FoundException("I found the key");
                }
            } catch (Exception e) {
                mutableKeys.add(key);
            }
        });
        Long sum = RawComputation.compute(mutableKeys.get(0));
        return Arrays.deepToString(mutableKeys.toArray()) + "\n"
                + Arrays.deepToString(answer.get(0).toArray()) + "\n" +
                "answer : " + sum;
    }

    private Long computeAsciiSum(List<String> words, List<Character> foundKey) {
        Printer.print("********** PLAIN TEXT **********");

        String text = words.stream().collect(Collectors.joining(" "));
        Printer.print(text);
        char[] letters = text.toCharArray();
        return LongStream.range(0, letters.length).map(c -> (int) c).sum();
    }

    private List<String> terminateIfDone(List<List<String>> decipher) {
        List<String> result = tryDecipher(decipher);
        if (decipher != null) {
            return result;
        }
        return null;
    }

    protected List<String> tryDecipher(List<List<String>> decipher) {
        List<String> words = Decipher.asListOfWords(decipher);
        boolean isDeciphered = words.stream().filter(w -> dictionaryWords.contains(w)).count() > 0.5 * words.size();
        return isDeciphered ? words : null;
    }

    protected List<List<String>> decipher(List<Character> key, List<List<String>> letterBlocksOf3) {
        return letterBlocksOf3.stream()
                .map(letterBlock -> decipher0(key, letterBlock))
                .collect(toList());
    }

    public List<String> decipher0(List<Character> keyBlock, List<String> letterBlock) {
        List<String> decryptedBlock = new ArrayList<>();
        IntStream.range(0, letterBlock.size()).forEachOrdered(
                i ->
                {
                    Integer s = (int) keyBlock.get(i);
                    Byte key = Byte.valueOf(s.toString());
                    Byte letter = Byte.valueOf(letterBlock.get(i));
                    decryptedBlock.add(decrypt(letter, key));
                }
        );
        return decryptedBlock;
    }


    public List<List<Character>> generateKeys(int keyLength) {
        List<List<Character>> keysAccu = ALPHABET.stream()
                .map(c -> {
                    List<Character> keyAccu = new ArrayList<>();
                    keyAccu.add(c);
                    return keyAccu;
                }).collect(toList());
        return generateKeys(keysAccu, keyLength);
    }

    public List<List<Character>> generateKeys(List<List<Character>> accu, int keyLength) {
        int size = accu.get(0).size();
        if (!accu.isEmpty() && size == keyLength) {
            return accu;
        }
        List<List<Character>> collect = ALPHABET.stream()
                .flatMap(c -> mergeToKeyAccu(Collections.copyOfNested(accu), c))
                .collect(toList());
        return generateKeys(collect, keyLength);
    }


    public Stream<List<Character>> mergeToKeyAccu(List<List<Character>> accu, Character c) {
        return accu.stream().map(list -> {
            list.add(c);
            return list;
        });
    }

    public Stream<String> getCipherStream() {
        return Java8Reader.reader(CIPHER).lines().flatMap(line -> {
            String regex = "" + ',';
            String[] words = line.split(regex);
            return Stream.of(words);
        });
    }

    protected String decrypt(Byte w, Byte key) {
        int decrypted = w ^ key;
        return Character.valueOf((char) decrypted).toString();
    }

    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new XORDecryption());
    }
}
