package com.yambacode.solutions.euler17;

import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

/**
 * Created by cbyamba on 2011-11-01.
 */
public class CountTalkAlgorithm extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return compute().toString();
    }

    /**
     * holds the existence of worded 1..9s in counting up to 1000
     */
    public enum CountIndex0 {

        ONE("one", 9 * 10),
        TWO("two", 9 * 10),
        THREE("three", 9 * 10),
        FOUR("four", 9 * 10),
        FIVE("five", 9 * 10),
        SIX("six", 9 * 10),
        SEVEN("seven", 9 * 10),
        EIGHT("eight", 9 * 10),
        NINE("nine", 9 * 10),
        TEN("ten", 10);


        private int length;
        private int weight;

        CountIndex0(String value, int weight) {
            this.length = value.length();
            this.weight = weight;
        }

        public int getLength() {
            return length;
        }

        public int getWeight() {
            return weight;
        }
    }

    /**
     * holds the existence of worded 11..19s in counting up to 1000
     */
    public enum CountIndex1Coefficient1 {

        ELEVEN("eleven", 10),
        TWELVE("twelve", 10),
        THIRTEEN("thirteen", 10),
        FOURTEEN("fourteen", 10),
        FIFTEEN("fifteen", 10),
        SIXTEEN("sixteen", 10),
        SEVENTEEN("seventeen", 10),
        EIGHTEEN("eighteen", 10),
        NINETEEN("nineteen", 10);

        private int length;
        private int weight;

        CountIndex1Coefficient1(String value, int weight) {
            this.length = value.length();
            this.weight = weight;
        }


        public int getLength() {
            return length;
        }

        public int getWeight() {
            return weight;
        }
    }

    public enum CountIndex2 {

        TWENTY("twenty", 100),
        THIRTY("thirty", 100),
        FOURTY("fourty", 100),
        FIFTY("fifty", 100),
        SIXTY("sixty", 100),
        EIGHTY("eighty", 100),
        NINETY("ninety", 100);

        private int length;
        private int weight;

        CountIndex2(String value, int weight) {
            this.length = value.length();
            this.weight = weight;
        }

        public int getLength() {
            return length;
        }

        public int getWeight() {
            return weight;
        }
    }

    public enum CountHundreds {

        ONE("onehundred", 100),
        TWO("twohundred", 100),
        THREE("threehundred", 100),
        FOUR("fourhundred", 100),
        FIVE("fivehundred", 100),
        SIX("sixhundred", 100),
        SEVEN("sevenhundred", 100),
        EIGHT("eighthundred", 100),
        NINE("ninehundred", 100),
        AND("and", 90 * 9);

        private int weight;
        private int length;

        CountHundreds(String value, int weight) {
            this.length = value.length();
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getLength() {
            return length;
        }
    }

    public Number compute() {
        int sum = 0;
        for (CountIndex0 e : CountIndex0.values()) {
            sum += e.getLength() * e.getWeight();
        }
        for (CountHundreds e : CountHundreds.values()) {
            sum += e.getLength() * e.getWeight();
        }
        for (CountIndex1Coefficient1 e : CountIndex1Coefficient1.values()) {
            sum += e.getLength() * e.getWeight();
        }
        for (CountIndex2 e : CountIndex2.values()) {
            sum += e.getLength() * e.getWeight();
        }
        return sum + "onethousand".length();
    }

    public static void main(String[] args) {
        EulerRunner.runEulerSolvers(new CountTalkAlgorithm());
    }
}
