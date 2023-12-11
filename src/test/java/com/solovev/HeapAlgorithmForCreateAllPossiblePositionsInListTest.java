package com.solovev;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static com.solovev.algorithms.HeapAlgorithmForCreateAllPossiblePositionsInList.*;

class HeapAlgorithmForCreateAllPossiblePositionsInListTest {

    @Test
    void getAllRecursiveEmpty() {
        List<Integer> empty = List.of();
        Collection<List<Integer>> expectedCollection = Set.of(empty);
        assertEquals(expectedCollection,getAllRecursivePermutations(empty));
    }
    @Test
    void getAll1() {
        List<Integer> one = List.of(1);
        Collection<List<Integer>> expectedCollection = new HashSet<>();
        expectedCollection.add(one);

        assertEquals(expectedCollection,getAllRecursivePermutations(one));
    }
    @Test
    void getAll2() {
        List<Integer> two = List.of(1,2);
        Collection<List<Integer>> expectedCollection = Set.of(
                List.of(1, 2),
                List.of(2, 1));

        assertEquals(expectedCollection,getAllRecursivePermutations(two));
    }
    @Test
    void getAll3() {
        List<Integer> three = List.of(1,2,3);
        Collection<List<Integer>> expectedCollection = Set.of(
                List.of(2, 1, 3),
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(3, 1, 2),
                List.of(2, 3, 1),
                List.of(3, 2, 1));

        assertEquals(expectedCollection,getAllRecursivePermutations(three));
    }
    @Test
    void getAll4() {
        List<Integer> four = List.of(1, 2, 3, 4);
        Set<List<Integer>> expectedCollection = Set.of(
                List.of(1, 2, 3, 4),
                List.of(1, 2, 4, 3),
                List.of(1, 3, 2, 4),
                List.of(1, 3, 4, 2),
                List.of(1, 4, 2, 3),
                List.of(1, 4, 3, 2),
                List.of(2, 1, 3, 4),
                List.of(2, 1, 4, 3),
                List.of(2, 3, 1, 4),
                List.of(2, 3, 4, 1),
                List.of(2, 4, 1, 3),
                List.of(2, 4, 3, 1),
                List.of(3, 1, 2, 4),
                List.of(3, 1, 4, 2),
                List.of(3, 2, 1, 4),
                List.of(3, 2, 4, 1),
                List.of(3, 4, 1, 2),
                List.of(3, 4, 2, 1),
                List.of(4, 1, 2, 3),
                List.of(4, 1, 3, 2),
                List.of(4, 2, 1, 3),
                List.of(4, 2, 3, 1),
                List.of(4, 3, 1, 2),
                List.of(4, 3, 2, 1)
        );
        assertEquals(expectedCollection, getAllRecursivePermutations(four));
    }
    @Test
    void getAll5() {
        List<Integer> five = List.of(1, 2, 3, 4, 5);
        Collection<List<Integer>> expectedCollection = Set.of(
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 5, 4),
                List.of(1, 2, 4, 3, 5),
                List.of(1, 2, 4, 5, 3),
                List.of(1, 2, 5, 3, 4),
                List.of(1, 2, 5, 4, 3),
                List.of(1, 3, 2, 4, 5),
                List.of(1, 3, 2, 5, 4),
                List.of(1, 3, 4, 2, 5),
                List.of(1, 3, 4, 5, 2),
                List.of(1, 3, 5, 2, 4),
                List.of(1, 3, 5, 4, 2),
                List.of(1, 4, 2, 3, 5),
                List.of(1, 4, 2, 5, 3),
                List.of(1, 4, 3, 2, 5),
                List.of(1, 4, 3, 5, 2),
                List.of(1, 4, 5, 2, 3),
                List.of(1, 4, 5, 3, 2),
                List.of(1, 5, 2, 3, 4),
                List.of(1, 5, 2, 4, 3),
                List.of(1, 5, 3, 2, 4),
                List.of(1, 5, 3, 4, 2),
                List.of(1, 5, 4, 2, 3),
                List.of(1, 5, 4, 3, 2),
                List.of(2, 1, 3, 4, 5),
                List.of(2, 1, 3, 5, 4),
                List.of(2, 1, 4, 3, 5),
                List.of(2, 1, 4, 5, 3),
                List.of(2, 1, 5, 3, 4),
                List.of(2, 1, 5, 4, 3),
                List.of(2, 3, 1, 4, 5),
                List.of(2, 3, 1, 5, 4),
                List.of(2, 3, 4, 1, 5),
                List.of(2, 3, 4, 5, 1),
                List.of(2, 3, 5, 1, 4),
                List.of(2, 3, 5, 4, 1),
                List.of(2, 4, 1, 3, 5),
                List.of(2, 4, 1, 5, 3),
                List.of(2, 4, 3, 1, 5),
                List.of(2, 4, 3, 5, 1),
                List.of(2, 4, 5, 1, 3),
                List.of(2, 4, 5, 3, 1),
                List.of(2, 5, 1, 3, 4),
                List.of(2, 5, 1, 4, 3),
                List.of(2, 5, 3, 1, 4),
                List.of(2, 5, 3, 4, 1),
                List.of(2, 5, 4, 1, 3),
                List.of(2, 5, 4, 3, 1),
                List.of(3, 1, 2, 4, 5),
                List.of(3, 1, 2, 5, 4),
                List.of(3, 1, 4, 2, 5),
                List.of(3, 1, 4, 5, 2),
                List.of(3, 1, 5, 2, 4),
                List.of(3, 1, 5, 4, 2),
                List.of(3, 2, 1, 4, 5),
                List.of(3, 2, 1, 5, 4),
                List.of(3, 2, 4, 1, 5),
                List.of(3, 2, 4, 5, 1),
                List.of(3, 2, 5, 1, 4),
                List.of(3, 2, 5, 4, 1),
                List.of(3, 4, 1, 2, 5),
                List.of(3, 4, 1, 5, 2),
                List.of(3, 4, 2, 1, 5),
                List.of(3, 4, 2, 5, 1),
                List.of(3, 4, 5, 1, 2),
                List.of(3, 4, 5, 2, 1),
                List.of(3, 5, 1, 2, 4),
                List.of(3, 5, 1, 4, 2),
                List.of(3, 5, 2, 1, 4),
                List.of(3, 5, 2, 4, 1),
                List.of(3, 5, 4, 1, 2),
                List.of(3, 5, 4, 2, 1),
                List.of(4, 1, 2, 3, 5),
                List.of(4, 1, 2, 5, 3),
                List.of(4, 1, 3, 2, 5),
                List.of(4, 1, 3, 5, 2),
                List.of(4, 1, 5, 2, 3),
                List.of(4, 1, 5, 3, 2),
                List.of(4, 2, 1, 3, 5),
                List.of(4, 2, 1, 5, 3),
                List.of(4, 2, 3, 1, 5),
                List.of(4, 2, 3, 5, 1),
                List.of(4, 2, 5, 1, 3),
                List.of(4, 2, 5, 3, 1),
                List.of(4, 3, 1, 2, 5),
                List.of(4, 3, 1, 5, 2),
                List.of(4, 3, 2, 1, 5),
                List.of(4, 3, 2, 5, 1),
                List.of(4, 3, 5, 1, 2),
                List.of(4, 3, 5, 2, 1),
                List.of(4, 5, 1, 2, 3),
                List.of(4, 5, 1, 3, 2),
                List.of(4, 5, 2, 1, 3),
                List.of(4, 5, 2, 3, 1),
                List.of(4, 5, 3, 1, 2),
                List.of(4, 5, 3, 2, 1),
                List.of(5, 1, 2, 3, 4),
                List.of(5, 1, 2, 4, 3),
                List.of(5, 1, 3, 2, 4),
                List.of(5, 1, 3, 4, 2),
                List.of(5, 1, 4, 2, 3),
                List.of(5, 1, 4, 3, 2),
                List.of(5, 2, 1, 3, 4),
                List.of(5, 2, 1, 4, 3),
                List.of(5, 2, 3, 1, 4),
                List.of(5, 2, 3, 4, 1),
                List.of(5, 2, 4, 1, 3),
                List.of(5, 2, 4, 3, 1),
                List.of(5, 3, 1, 2, 4),
                List.of(5, 3, 1, 4, 2),
                List.of(5, 3, 2, 1, 4),
                List.of(5, 3, 2, 4, 1),
                List.of(5, 3, 4, 1, 2),
                List.of(5, 3, 4, 2, 1),
                List.of(5, 4, 1, 2, 3),
                List.of(5, 4, 1, 3, 2),
                List.of(5, 4, 2, 1, 3),
                List.of(5, 4, 2, 3, 1),
                List.of(5, 4, 3, 1, 2),
                List.of(5, 4, 3, 2, 1)
        );

        assertEquals(expectedCollection, getAllRecursivePermutations(five));
    }

    @Test
    void bigNumbersTests(){
        List<Integer> nine = List.of(1,2,3,4,5,6,7,8,9);
        int expectedLength = 362880;
        assertEquals(expectedLength, getAllRecursivePermutations(nine).size());
    }
}