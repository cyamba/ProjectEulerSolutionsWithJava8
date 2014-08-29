package com.yambacode.math;

import com.yambacode.common.io.Printer;
import com.yambacode.common.util.NumberStringConversions;
import com.yambacode.solutions.euler61.FigurativeNumber;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.LongFunction;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.lang.Math.*;
import static java.util.Arrays.copyOfRange;
import static java.util.stream.Collectors.toList;

/**
 * Created by cbyamba on 2014-01-24.
 */
public class Numbers {

    public static boolean isNGonalNumber(FigurativeNumber lastPiece, FigurativeType... types) {
        return Stream.of(types).anyMatch(type -> isNGonalNumber(lastPiece, type));
    }

    public static boolean isNGonalNumber(FigurativeNumber number, FigurativeType type) {
        switch (type) {
            case TRIANGLE:
                isTriangleGeneralized(number.getValue());
            case SQUARE:
                isSquareGeneralized(number.getValue());
            case PENTAGONAL:
                isPentagonalGeneralized(number.getValue());
            case HEXAGONAL:
                isHexagonalGeneralized(number.getValue());
            case HEPTAGONAL:
                isHeptagonalGeneralized(number.getValue());
            case OCTAGONAL:
                isOctagonalGeneralized(number.getValue());
            default:
                return false;
        }
    }


    public static enum FigurativeType {
        TRIANGLE(3),
        SQUARE(4),
        PENTAGONAL(5),
        HEXAGONAL(6),
        HEPTAGONAL(7),
        OCTAGONAL(8),
        UNDEFINED(-1);

        private int type;

        FigurativeType(int _type) {
            type = _type;
        }

        public int getType() {
            return type;
        }

        public static FigurativeType valueOf(long val) {
            int value = (int) val; //TODO fix this
            if (isTriangleGeneralized(value)) {
                return TRIANGLE;
            }
            if (isSquareGeneralized(value)) {
                return SQUARE;
            }
            if (isPentagonalGeneralized(value)) {
                return PENTAGONAL;
            }
            if (isHeptagonalGeneralized(value)) {
                return HEXAGONAL;
            }
            if (isHeptagonalGeneralized(value)) {
                return HEPTAGONAL;
            }
            if (isOctagonalGeneralized(value)) {
                return OCTAGONAL;
            }
            return UNDEFINED;
        }

        public static FigurativeType valueOf(int type) {
            switch (type) {
                case 3:
                    return TRIANGLE;
                case 4:
                    return SQUARE;
                case 5:
                    return PENTAGONAL;
                case 6:
                    return HEXAGONAL;
                case 7:
                    return HEPTAGONAL;
                case 8:
                    return OCTAGONAL;
                default:
                    return UNDEFINED;
            }
        }

        public FigurativeType next() {
            return valueOf(type + 1);
        }
    }

    public static long[] fibbo(long max, long[] numbers) {
        int length = numbers.length;
        if (numbers[length - 1] >= max) {
            return LongStream.of(copyOfRange(numbers, 0, length - 1)).toArray();
        }
        return fibbo(max,
                LongStream.concat(
                        LongStream.of(numbers),
                        LongStream.of(numbers[length - 1] + numbers[length - 2])).toArray());
    }


    public static long[] fibbo(int length, long[] numbers) {
        int size = numbers.length;
        if (size >= length) {
            return LongStream.of(copyOfRange(numbers, 0, size - 1)).toArray();
        }
        return fibbo(length,
                LongStream.concat(
                        LongStream.of(numbers),
                        LongStream.of(numbers[size - 1] + numbers[size - 2])).toArray());
    }

    public static List<BigInteger> fibbo(int length, BigInteger[] numbers) {
        List<BigInteger> result = new ArrayList<>(length);
        BigInteger first = null;
        BigInteger second = null;
        result.add(first = numbers[0]);
        result.add(second = numbers[1]);
        while (result.size() < length) {
            result.add(first.add(second));
            first = result.get(result.size() - 2);
            second = result.get(result.size() - 1);
        }
        return result;
    }

    /**
     * ax^2 + bx +c
     *
     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static long generalQuadradicNumber(long n, long a, long b, long c) {
        return a * n * n + b * n + c;
    }

    /**
     * an^2+bn+c
     * => n = -(b/a)/2+sqrt((b*b/a*a)/4-c/a)
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static long generalQuadradicRoot(long a, long b, long c) {
        return -a / b / 2 + (long) sqrt((double) b * b / (double) a * a / 4d - (double) c / a);
    }

    /**
     * ax^2 + bx +c
     *
     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int generalQuadradicNumber(int n, int a, int b, int c) {
        return a * n * n + b * n + c;
    }

    /**
     * an^2+bn+c
     * => n = -(b/a)/2+sqrt((b*b/a*a)/4-c/a)
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int generalQuadradicRoot(int a, int b, int c) {
        int result = (int) ((-b / (double) a) / 2d + sqrt((double) b * b / (double) a * a / 4d - (double) c / a));
        return result;
    }

    public static long triangularNumber(long n) {
        return n * (n + 1) / 2;
    }


    public static int triangularNumber(int n) {
        return n * (n + 1) / 2;
    }

    public static long squareNumber(long n) {
        return n * n;
    }

    public static int squareNumber(int n) {
        return n * n;
    }

    public static long pentagonalNumber(long n) {
        return n * (3 * n - 1) / 2;
    }

    public static int pentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }

    public static long heptagonalNumber(long n) {
        return n * (5 * n - 3) / 2;
    }

    public static int heptagonalNumber(int n) {
        return n * (5 * n - 3) / 2;
    }

    public static long hexagonalNumber(long n) {
        return n * (2 * n - 1);
    }

    public static int hexagonalNumber(int n) {
        return n * (2 * n - 1);
    }

    public static long octagonalNumber(long n) {
        return n * (3 * n - 2);
    }

    public static int octagonalNumber(int n) {
        return n * (3 * n - 2);
    }

    public static LongFunction<Long> triangularLambda() {
        return n -> triangularNumber(n);
    }

    public static LongFunction<Long> pentagonalLambda() {
        return n -> pentagonalNumber(n);
    }

    public static LongFunction<Long> heptagonalLambda() {
        return n -> heptagonalNumber(n);
    }

    public static boolean isPentagonal(int number) {
        return pentagonalNumbersLessThanImperative(number).contains(number);
    }

    public static List<Integer> nGonalNumbers(int start, int endInclusive, IntUnaryOperator function) {
        return IntStream
                .rangeClosed(start, endInclusive)
                .map(function)
                .boxed()
                .collect(toList());
    }

    public static IntStream nGonalNumberIntStream(int start, int endInclusive, IntUnaryOperator function) {
        return IntStream
                .rangeClosed(start, endInclusive)
                .map(function);
    }

    public static Stream<Integer> nGonalNumberIntegerStream(int start, int endInclusive, IntUnaryOperator function) {
        return nGonalNumberIntStream(start, endInclusive, function).mapToObj(x -> x);
    }

    public static List<Integer> triangleNumbersRangeClosed(int start, int endInclusive) {
        return nGonalNumbers(start, endInclusive, Numbers::triangularNumber);
    }

    public static List<Integer> squareNumbersRangeClosed(int start, int endInclusive) {
        return nGonalNumbers(start, endInclusive, Numbers::squareNumber);
    }

    public static List<Integer> pentagonalNumbersRangeClosed(int start, int endInclusive) {
        return nGonalNumbers(start, endInclusive, Numbers::pentagonalNumber);
    }

    public static List<Integer> hexagonalNumbersRangeClosed(int start, int endInclusive) {
        return nGonalNumbers(start, endInclusive, Numbers::hexagonalNumber);
    }

    public static List<Integer> heptagonalNumbersRangeClosed(int start, int endInclusive) {
        return nGonalNumbers(start, endInclusive, Numbers::heptagonalNumber);
    }

    public static List<Integer> octagonalNumbersRangeClosed(int start, int endIclusive) {
        return nGonalNumbers(start, endIclusive, Numbers::octagonalNumber);
    }

    public static List<Integer> figurativeNumbers(FigurativeType type, int maxInclusive) {
        switch (type) {
            case TRIANGLE:
                return triangularNumbersLessThan(1, maxInclusive);
            case SQUARE:
                return squareNumbersLessThan(1, maxInclusive);
            case PENTAGONAL:
                return pentagonalNumbersLessThan(1, maxInclusive);
            case HEXAGONAL:
                return hexagonalNumbersLessThan(1, maxInclusive);
            case HEPTAGONAL:
                return heptagonalNumbersLessThan(1, maxInclusive);
            case OCTAGONAL:
                return octagonalNumbersLessThan(1, maxInclusive);
        }
        return null;
    }

    public static List<Integer> triangularNumbersLessThan(int start, int maxInclusive) {
        double halfCoefficient = 1d / 2d;
        double endInclusive = -halfCoefficient + Math.sqrt((1d / 4d) + maxInclusive);
        return triangleNumbersRangeClosed(start, (int) endInclusive);
    }

    public static List<Integer> squareNumbersLessThan(int start, int maxInclusive) {
        return squareNumbersRangeClosed(start, (int) sqrt(maxInclusive));
    }

    public static List<Integer> pentagonalNumbersLessThan(int start, int maxInclusive) {
        double halfCoefficient = 1d / 6d;
        double endInclusive = halfCoefficient + Math.sqrt(((25d / 36d)) * (double) maxInclusive);
        return pentagonalNumbersRangeClosed(start, (int) endInclusive);
    }

    public static List<Integer> hexagonalNumbersLessThan(int start, int maxInclusive) {
        double halfCoefficient = 1d / 4d;
        double endInclusive = halfCoefficient + Math.sqrt((3d / 2d * (double) maxInclusive));
        return hexagonalNumbersRangeClosed(start, (int) endInclusive);
    }

    public static List<Integer> heptagonalNumbersLessThan(int start, int maxInclusive) {
        double halfCoefficient = 3d / 10d;
        double endInclusive = halfCoefficient + Math.sqrt((9d + 40d * (double) maxInclusive) / 100d);
        return heptagonalNumbersRangeClosed(start, (int) endInclusive);
    }

    public static List<Integer> octagonalNumbersLessThan(int start, int maxInclusive) {
        double halfCoefficient = 1d / 3d;
        double endInclusive = halfCoefficient + Math.sqrt((4d / 9d * (double) maxInclusive));
        return octagonalNumbersRangeClosed(start, (int) endInclusive);
    }

    //TODO lambdaify if efficient!
    public static List<Integer> pentagonalNumbersLessThanImperative(int maxInclusive) {
        int i = 1;
        List<Integer> result = new ArrayList<>();
        while (pentagonalNumber(i) <= maxInclusive) {
            result.add(pentagonalNumber(i));
            i++;
        }
        return result.stream().collect(toList());
    }

    @Deprecated
    public static boolean isTriangularNumber(int n) {
        return triangularNumbersLessThan((int) Math.floor(n), (int) Math.ceil(n)).contains(n);
    }

    @Deprecated
    public static boolean isSquareNumber(int n) {
        return squareNumbersLessThan((int) sqrt(n), (int) ceil(n) + 1).contains(n);
    }

    @Deprecated
    public static boolean isSquareNumberSolveEquation(int n) {
        return squareNumber((int) floor(sqrt(n))) == n;
    }

    public static boolean isSquareGeneralized(int n) {
        return isQuadraticNumber(1, 0, 0, n);
    }

    /**
     * (n)(n+1)/2 = candidate => n^2 + n = 2*candidate => n^2 + n = 2*candidate
     *
     * @return
     */
    public static boolean isTriangleGeneralized(int candidate) {
        return isQuadraticNumber(1, 1, 0, 2 * candidate);
    }

    /**
     * n*(3*n-1)/2 = candidate => 3*n^2-*n = 2*candidate
     *
     * @return boolean true if satisfies above quadratic equation.
     */
    public static boolean isPentagonalGeneralized(int candidate) {
        return isQuadraticNumber(3, -1, 0, 2 * candidate);
    }

    /**
     * n*(2*n-1) = candidate => 2*n^2-n = candidate
     *
     * @param candidate
     * @return
     */
    public static boolean isHexagonalGeneralized(int candidate) {
        return isQuadraticNumber(2, -1, 0, candidate);
    }

    /**
     * n*(5*n-3)/2 = candidate => 5*n^2 -3*n = 2*candidate
     *
     * @param candidate
     * @return
     */
    public static boolean isHeptagonalGeneralized(int candidate) {
        return isQuadraticNumber(5, -3, 0, 2 * candidate);
    }

    /**
     * n*(3*n-2) = candidate =>  3*n-2*n  = candidate
     *
     * @param candidate
     * @return
     */
    public static boolean isOctagonalGeneralized(int candidate) {
        return isQuadraticNumber(3, -2, 0, candidate);
    }

    public static boolean areTriangleNumbers(int... numbers) {
        return IntStream.of(numbers).allMatch(Numbers::isTriangleGeneralized);
    }

    public static boolean areSquareNumbers(int... numbers) {
        return IntStream.of(numbers).allMatch(Numbers::isSquareGeneralized);
    }

    public static boolean arePentagonalNumbers(int... numbers) {
        return IntStream.of(numbers).allMatch(Numbers::isPentagonalGeneralized);
    }

    public static boolean areHexagonalNumbers(int... numbers) {
        return IntStream.of(numbers).allMatch(Numbers::isHeptagonalGeneralized);
    }

    public static boolean areHeptagonalNumbers(int... numbers) {
        return IntStream.of(numbers).allMatch(Numbers::isHeptagonalGeneralized);
    }

    public static boolean areOctagonalNumbers(int... numbers) {
        return IntStream.of(numbers).allMatch(Numbers::isOctagonalGeneralized);
    }

    /**
     * ax^2 +bx+originalC = candidate
     * c = originalC-candidate
     *
     * @param a
     * @param b
     * @param candidate
     * @return
     */
    protected static boolean isQuadraticNumber(int a, int b, int originalC, int candidate) {
        int c = originalC - candidate;
        int root = generalQuadradicRoot(a, b, c);
        int generalQuadradicNumber = generalQuadradicNumber(root, a, b, originalC);
        return generalQuadradicNumber == candidate;
    }


    public static boolean isPentagonalNumber(int n) {
        return pentagonalNumbersRangeClosed((int) Math.sqrt(n), (int) Math.ceil(n) + 1).contains(n);
    }

    public static boolean isHexagonalNumber(int n) {
        return hexagonalNumbersRangeClosed((int) Math.floor(n), (int) Math.ceil(n)).contains(n);
    }


    public static boolean isHeptagonalNumber(int n) {
        return heptagonalNumbersLessThan((int) Math.floor(n), (int) Math.ceil(n)).contains(n);
    }


    public static long nextOddComposite(long x) {
        long candidate = (x % 2 == 0) ? x + 1 : x + 2;
        while (Primes.isPrime(candidate)) {
            candidate += 2;
        }
        return candidate;
    }

    public static Integer multiplicativePersistence(Integer number) {
        return mp0(number, 0);
    }

    private static Integer mp0(Integer number, int count) {
        if (number.toString().length() == 1) {
            return count;
        }
        int[] digits = NumberStringConversions.intToIntArray(number);
        return mp0(IntStream.of(digits).reduce((prod, x) -> prod * x).getAsInt(), ++count);
    }

    private static boolean mp0Root(Integer number, int count, int persistence) {
        if (count > persistence) {
            return false; //optimization. Don't look further if count!=persistence
        }
        if (number.toString().length() == 1 && count == persistence) {
            return true;
        }
        int[] digits = NumberStringConversions.intToIntArray(number);
        return mp0Root(IntStream.of(digits).reduce((prod, x) -> prod * x).getAsInt(), ++count, persistence);
    }

    public static Integer lowestMultiplicativePersistenceRoot(Integer persistence) {
        int number = 10;
        while (mp0Root(number, 0, persistence)) {
            number++;
        }
        return number;
    }

    public static void main(String... args) {

        Printer.print(pentagonalNumbersLessThan(1, 100).toArray());
        Printer.print("" + isPentagonal(128627));
        Printer.print("" + isSquareNumber(4));

        int n = 4;


        boolean areSquares = areSquareNumbers(1, 4, 9, 16, 36);
        Printer.print(String.format("%s", isSquareNumberSolveEquation(9)));
        Printer.print(String.format("%s", areSquares));

        // 1*2/2 , 2*3/2, 3*4/2, 4*5/2, 5*6/2
        //1,3,6,10,15,21
        boolean isQuadratic = isTriangleGeneralized(21);
        Printer.print(String.format("%s", isQuadratic));

        Printer.print(pentagonalNumbersLessThan(1, 100).toArray());
        isQuadratic = isPentagonalGeneralized(92);
        Printer.print(String.format("%s", isQuadratic));

        Printer.print("=====");
        Printer.print("Hexagonal : ");
        Printer.print(hexagonalNumbersLessThan(1, 100).toArray());
        isQuadratic = isHexagonalGeneralized(66);
        Printer.print(String.format("%s", isQuadratic));

        Printer.print("Heptagonal : ");
        Printer.print(heptagonalNumbersLessThan(1, 300).toArray());
        isQuadratic = isHeptagonalGeneralized(34);
        Printer.print(String.format("%s", isQuadratic));

        Printer.print("Octagonal : ");
        int[] objects = octagonalNumbersLessThan(1, 100).stream().mapToInt(x -> x).toArray();
        Printer.print(objects);
        Printer.print("areOctagonalNumbers = " + areOctagonalNumbers(objects));
        isQuadratic = isOctagonalGeneralized(96);
        Printer.print(String.format("%s", isQuadratic));

        Printer.print("fibbo : " + fibbo(10, new BigInteger[]{BigInteger.ONE, BigInteger.ONE}));
    }


}
