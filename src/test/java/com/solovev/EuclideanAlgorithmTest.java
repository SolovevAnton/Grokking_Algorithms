package com.solovev;

import com.solovev.algorithms.EuclideanAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanAlgorithmTest {
    @Test
    void testGCDWithTwoPrimes() {
        assertEquals(1, EuclideanAlgorithm.findGCD(17, 13));
    }

    @Test
    void testGCDWithZeroes() {
        assertEquals(7, EuclideanAlgorithm.findGCD(7, 0));
        assertEquals(0, EuclideanAlgorithm.findGCD(0, 0));
    }
    @Test
    void testGCDWithWrongOrder() {
        assertThrows(IllegalArgumentException.class,()-> EuclideanAlgorithm.findGCD(0, 5));
        assertThrows(IllegalArgumentException.class,()-> EuclideanAlgorithm.findGCD(4, 8));
    }

    @Test
    void testGCDWithEqualNumbers() {
        assertEquals(9, EuclideanAlgorithm.findGCD(9, 9));
    }

    @Test
    void testGCDHappyPath() {
        assertEquals(6, EuclideanAlgorithm.findGCD(54, 24));
        assertEquals(1, EuclideanAlgorithm.findGCD(25, 18));
        assertEquals(3, EuclideanAlgorithm.findGCD(99, 39));
    }

}