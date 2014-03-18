package com.seewhy.solutions.euler59;

import com.seewhy.common.collections.CollectionBlocks;
import com.seewhy.common.collections.Collections;
import com.seewhy.common.io.Java8Reader;
import com.seewhy.common.io.Printer;
import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by cbyamba on 2014-03-07.
 */
public class XORDecryption extends AbstractEulerSolver {

    private static final int KEY_LENGTH = 3;

    public static final String CIPHER = "/Users/cbyamba/programming/github/EulerSolutionsWithJava8" +
            "/src/main/java/com/seewhy/solutions/euler59/cipher1.txt";

    private static final String DICTIONARY = "/Users/cbyamba/programming/github/EulerSolutionsWithJava8" +
            "/src/main/java/com/seewhy/solutions/euler59/words_remove_before_commit";

    private static final List<Character> ALPHABET = Collections.integerToCharacterList(
            IntStream.range(65, 65 + 26)
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
        List<List<Character>> mutableResult = new ArrayList<>();
        try {
            allKeys.parallelStream()
                    .peek(key -> Printer.print(key.toArray()))
                    .forEach(key -> {
                        if (isDeciphering(key, wordBlocksOf3)) {
                            mutableResult.add(key);
                            throw new RuntimeException(
                                    String.format("terminate execution. answer %s is found",
                                            Arrays.deepToString(key.toArray())));
                        }
                    });
        } catch (Exception e) {
            //DO nothing
        }
        return Arrays.deepToString(mutableResult.toArray());
    }

    public boolean isDeciphering(List<Character> key, List<List<String>> wordBlocksOf3) {
        return wordBlocksOf3.stream().map(wordBlock -> decipher(key, wordBlock))
                .filter(word -> dictionaryWords.contains(word))

                .count() > 10;
    }

    public List<String> decipher(List<Character> keyBlock, List<String> wordBlock) {
        List<String> decryptedBlock = new ArrayList<>();
        IntStream.range(0, wordBlock.size()).forEachOrdered(
                i ->
                {
                    Byte word = Byte.valueOf(keyBlock.get(i).toString());
                    Byte key = Byte.valueOf(wordBlock.get(i));
                    decryptedBlock.add(decrypt(word, key));
                }
        );
        return decryptedBlock;
    }


    public List<List<Character>> generateKeys(int keyLength) {
        List<List<Character>> keysAccu = ALPHABET.stream().map(c -> {
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
