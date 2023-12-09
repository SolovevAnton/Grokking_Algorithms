package com.solovev.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractSortTest {
    private final Sort<Integer> sortClass = provideSorter();

    protected abstract Sort<Integer> provideSorter();

    @Test
    void testSortWithEmptyList() {
        List<Integer> unsorted = Collections.emptyList();
        List<Integer> sorted = sortClass.sort(unsorted);
        assertEquals(unsorted, sorted);
    }

    @Test
    void testSortWithOneElement() {
        List<Integer> unsorted = List.of(5);
        List<Integer> sorted = sortClass.sort(unsorted);
        assertEquals(unsorted, sorted);
    }

    @Test
    void testSortWithMultipleElements() {
        List<Integer> unsorted = List.of(5, 2, 8, 1, 3);
        List<Integer> sorted = sortClass.sort(unsorted);
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 8);
        assertEquals(expected, sorted);
    }

    @Test
    void testSortWithAlreadySorted() {
        List<Integer> unsorted = List.of(1, 2, 3, 5, 8);
        List<Integer> sorted = sortClass.sort(unsorted);
        assertEquals(unsorted, sorted);
    }

    @Test
    void testSortWithDescendingOrder() {
        List<Integer> unsorted = List.of(8, 5, 3, 2, 1);
        List<Integer> sorted = sortClass.sort(unsorted);
        List<Integer> expected = List.of(1, 2, 3, 5, 8);
        assertEquals(expected, sorted);
    }
    @Test
    void testSortWithRepeatedElements() {
        List<Integer> unsorted = List.of(5, 2, 8, 1, 3, 2, 5);
        List<Integer> sorted = sortClass.sort(unsorted);
        List<Integer> expected = Arrays.asList(1, 2, 2, 3, 5, 5, 8);
        assertEquals(expected, sorted);
    }

    @Test
    void testSortWithAllSameElements() {
        List<Integer> unsorted = List.of(4, 4, 4, 4, 4);
        List<Integer> sorted = sortClass.sort(unsorted);
        assertEquals(unsorted, sorted);
    }
 }
