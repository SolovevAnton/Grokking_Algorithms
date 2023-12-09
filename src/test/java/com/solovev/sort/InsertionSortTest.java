package com.solovev.sort;

class InsertionSortTest extends AbstractSortTest{
    @Override
    protected Sort<Integer> provideSorter() {
        return new InsertionSort<>();
    }
}