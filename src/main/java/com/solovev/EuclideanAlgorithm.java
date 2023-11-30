package com.solovev;

public class EuclideanAlgorithm {
    /**
     * finds grand common divisor for two numbers
     *
     * @return
     */
    public static int findGCD(int greaterNumber, int smallerNumber) {
        if (greaterNumber < smallerNumber) {
            throw new IllegalArgumentException("wrong arguments order");
        }
        return smallerNumber == 0
                ? greaterNumber
                : findGCD(smallerNumber, greaterNumber % smallerNumber);
    }
}
