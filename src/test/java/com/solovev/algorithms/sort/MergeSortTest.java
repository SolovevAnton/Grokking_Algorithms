package com.solovev.algorithms.sort;

public class MergeSortTest extends AbstractSortTest {
    @Override
    protected Sort<Integer> provideSorter() {
        return new MergeSort<>();
    }
}
