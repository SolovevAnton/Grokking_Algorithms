package com.solovev.algorithms.sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractSortTest {
    private final Sort<Integer> sortClass = provideSorter();

    protected abstract Sort<Integer> provideSorter();

    @Test
    void testSortWithEmptyList() {
        List<Integer> unsorted = Collections.emptyList();
        List<Integer> sorted = sortClass.sort(unsorted);
        assertEquals(unsorted, sorted, "Given: " + unsorted);
    }

    @Test
    void testSortWithOneElement() {
        List<Integer> unsorted = List.of(5);
        List<Integer> sorted = sortClass.sort(unsorted);
        assertEquals(unsorted, sorted, "Given: " + unsorted);
    }

    @Test
    void testSortSimplestSort() {
        List<Integer> unsorted = List.of(3, 2, 1);
        List<Integer> sorted = sortClass.sort(unsorted);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, sorted, "Given: " + unsorted);
    }

    @Test
    void testSortWithMultipleElements() {
        List<Integer> unsorted = List.of(5, 2, 8, 1, 3);
        List<Integer> sorted = sortClass.sort(unsorted);
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 8);
        assertEquals(expected, sorted, "Given: " + unsorted);
    }

    @Test
    void testSortWithAlreadySorted() {
        List<Integer> unsorted = List.of(1, 2, 3, 5, 8);
        List<Integer> sorted = sortClass.sort(unsorted);
        assertEquals(unsorted, sorted, "Given: " + unsorted);
    }

    @Test
    void testSortWithDescendingOrder() {
        List<Integer> unsorted = List.of(8, 5, 3, 2, 1);
        List<Integer> sorted = sortClass.sort(unsorted);
        List<Integer> expected = List.of(1, 2, 3, 5, 8);
        assertEquals(expected, sorted, "Given: " + unsorted);
    }

    @Test
    void testSortWithRepeatedElements() {
        List<Integer> unsorted = List.of(5, 2, 8, 1, 3, 2, 5);
        List<Integer> sorted = sortClass.sort(unsorted);
        List<Integer> expected = Arrays.asList(1, 2, 2, 3, 5, 5, 8);
        assertEquals(expected, sorted, "Given: " + unsorted);
    }

    @Test
    void testSortWithAllSameElements() {
        List<Integer> unsorted = List.of(4, 4, 4, 4, 4);
        List<Integer> sorted = sortClass.sort(unsorted);
        assertEquals(unsorted, sorted, "Given: " + unsorted);
    }

    @ParameterizedTest
    @ValueSource(ints = {100,1000,100_000})
    void testSortLargeList(int listSize) {
        List<Integer> unsorted = generateLargeRandomList(listSize);
        List<Integer> javaSorted = new ArrayList<>(unsorted);
        Collections.sort(javaSorted);

        List<Integer> yourSorted = new ArrayList<>(unsorted);
        yourSorted = sortClass.sort(yourSorted);

        // Check if both sorted lists are the same
        assertEquals(javaSorted, yourSorted, "Given: " + unsorted);
    }

    private List<Integer> generateLargeRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(Integer.MAX_VALUE));
        }
        return list;
    }
}
