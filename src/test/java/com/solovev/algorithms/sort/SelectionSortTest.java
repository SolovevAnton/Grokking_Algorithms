package com.solovev.algorithms.sort;

class SelectionSortTest extends AbstractSortTest{
    @Override
    protected Sort<Integer> provideSorter() {
        return new SelectionSort<>();
    }
}